package com.jiejie.service;

import com.jiejie.domain.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    void save(Role role);

    List<Role> findByIdOtherRole(String id);
}
