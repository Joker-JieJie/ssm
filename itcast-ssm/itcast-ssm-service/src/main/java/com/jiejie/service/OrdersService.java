package com.jiejie.service;

import com.jiejie.domain.Orders;

import java.util.List;

public interface OrdersService {

    public List<Orders> findAll(Integer page, Integer size);

    Orders findById(String id);
}
