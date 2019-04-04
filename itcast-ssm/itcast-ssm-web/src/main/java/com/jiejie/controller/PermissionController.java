package com.jiejie.controller;


import com.jiejie.domain.Permission;
import com.jiejie.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<Permission> permissionList = permissionService.findAll();
        model.addAttribute("permissionList", permissionList);
        return "permission-list";
    }

    //添加权限
    @RequestMapping("/save")
    public String save(Permission permission) {
        permissionService.save(permission);
        return "redirect:/permission/findAll";
    }
}
