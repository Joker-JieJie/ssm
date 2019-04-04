package com.jiejie.service;

import com.jiejie.domain.Permission;

import java.util.List;

public interface PermissionService {

    List<Permission> findAll();

    void save(Permission permission);
}
