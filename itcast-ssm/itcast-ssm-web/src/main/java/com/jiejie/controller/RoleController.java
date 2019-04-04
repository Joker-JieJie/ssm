package com.jiejie.controller;

import com.jiejie.domain.Role;
import com.jiejie.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

//    查询所有
    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<Role> roles = roleService.findAll();
        model.addAttribute("roleList", roles);
        return "role-list";
    }
    //添加
    @RequestMapping("/save")
    public String save(Role role) {

        roleService.save(role);

        return "redirect:/role/findAll";
    }
}
