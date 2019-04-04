package com.jiejie.service.impl;

import com.jiejie.dao.RoleDao;
import com.jiejie.domain.Role;
import com.jiejie.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    public List<Role> findAll() {

        return roleDao.findAll();
    }

    public void save(Role role) {
        roleDao.save(role);
    }

    //查询本用户没有的角色
    public List<Role> findByIdOtherRole(String id) {

        return roleDao.findByIdOtherRole(id);
    }
}
