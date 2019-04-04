package com.jiejie.dao;

import com.jiejie.domain.Permission;

import java.util.List;

public interface PermissionDao {
    List<Permission> findAll();

    void save(Permission permission);
}
