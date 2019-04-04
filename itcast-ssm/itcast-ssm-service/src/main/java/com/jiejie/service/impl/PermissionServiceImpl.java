package com.jiejie.service.impl;

import com.jiejie.dao.PermissionDao;
import com.jiejie.domain.Permission;
import com.jiejie.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    public List<Permission> findAll() {

        return permissionDao.findAll();
    }

    public void save(Permission permission) {
        permissionDao.save(permission);
    }
}
