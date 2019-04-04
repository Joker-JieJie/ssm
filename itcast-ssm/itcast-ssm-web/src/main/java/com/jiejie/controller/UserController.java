package com.jiejie.controller;

import com.jiejie.domain.Role;
import com.jiejie.domain.User;
import com.jiejie.service.RoleService;
import com.jiejie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {

        List<User> users = userService.findAll();
        model.addAttribute("userList", users);
        return "user-list";
    }

    @RequestMapping("/save")
    public String save(Model model, User user) {

        userService.save(user);
        return "redirect:/user/findAll";
    }

    //查询用户详情
    @RequestMapping("/findById")
    public String findById(String id, Model model) {

        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user-show";
    }

    //发现未添加角色
    @RequestMapping("/findUserByIdAndAllRole")
    public String findUserByIdAndAllRole(String id, Model model) {

        //根据id查询当前用户
        User users = userService.findById(id);
        //根据id查询当前用户还有什么角色没添加
        List<Role> roleList = roleService.findByIdOtherRole(id);

        model.addAttribute("users", users);
        model.addAttribute("roleList", roleList);

        return "user-role-add";
    }

    //给指定用户添加角色
    @RequestMapping("/saveRole")
    public String saveRole(String userId, String[] ids) {

        userService.saveRole(userId, ids);
        return "redirect:/user/findAll";
    }

}
