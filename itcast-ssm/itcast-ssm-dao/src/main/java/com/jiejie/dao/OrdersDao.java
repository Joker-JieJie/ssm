package com.jiejie.dao;

import com.jiejie.domain.Orders;

import java.util.List;

public interface OrdersDao {

    public List<Orders> findAll();

    Orders findById(String id);
}
