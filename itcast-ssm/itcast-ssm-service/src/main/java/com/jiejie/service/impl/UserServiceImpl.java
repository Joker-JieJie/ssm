package com.jiejie.service.impl;

import com.jiejie.dao.UserDao;
import com.jiejie.dao.User_RoleDao;
import com.jiejie.domain.Role;
import com.jiejie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private User_RoleDao user_roleDao;


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //用户登录
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.jiejie.domain.User user = userDao.findByUsername(username);
        List<SimpleGrantedAuthority> list = getAuthority(user.getRoles());
        User us = new User(user.getUsername(), user.getPassword(), user.getStatus() == 0 ? false : true, true, true, true, list);
        return us;
    }

    //作用就是返回一个List集合，集合中装入角色描述
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {

        List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }


    //查询所有用户
    public List<com.jiejie.domain.User> findAll() {
        return userDao.findAll();
    }


    //添加用户
    public void save(com.jiejie.domain.User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    //查询用户详情
    public com.jiejie.domain.User findById(String id) {

        return userDao.findById(id);
    }

    //查询未添加的角色
    public List<com.jiejie.domain.User> findByIdOtherRole(String id) {

        return userDao.findByIdOtherRole(id);
    }

    //为用户添加角色
    public void saveRole(String uid, String[] ids) {

        for (String id : ids) {
            user_roleDao.saveRole(uid, id);
        }
    }


}
