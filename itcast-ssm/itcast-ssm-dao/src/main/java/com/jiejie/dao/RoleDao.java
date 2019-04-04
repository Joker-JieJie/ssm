package com.jiejie.dao;

import com.jiejie.domain.Orders;
import com.jiejie.domain.Role;

import java.util.List;

public interface RoleDao {

    List<Role> findByUserId(String uid);

    List<Role> findAll();

    void save(Role role);

    List<Role> findByIdOtherRole(String uid);
}
