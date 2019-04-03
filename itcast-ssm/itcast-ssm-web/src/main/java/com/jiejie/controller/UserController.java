package com.jiejie.controller;

import com.jiejie.domain.User;
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

    @RequestMapping("/findAll")
    public String findAll(Model model) {

        List<User> users = userService.findAll();
        model.addAttribute("userList",users);
        return "user-list";
    }

    @RequestMapping("/save")
    public String save(Model model,User user) {

        userService.save(user);
        return "redirect:/user/findAll";
    }

    //查询用户详情
    @RequestMapping("/findById")
    public String findById(String id,Model model) {

        User user = userService.findById(id);
        model.addAttribute("user",user);
        return "user-show";
    }

}
