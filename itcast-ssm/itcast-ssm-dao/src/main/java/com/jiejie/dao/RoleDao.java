package com.jiejie.dao;

import com.jiejie.domain.Orders;

import java.util.List;

public interface RoleDao {

    List<Orders> findByUserId(String uid);
}
