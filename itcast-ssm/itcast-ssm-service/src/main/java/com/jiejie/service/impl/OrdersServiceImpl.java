package com.jiejie.service.impl;

import com.github.pagehelper.PageHelper;
import com.jiejie.dao.OrdersDao;
import com.jiejie.domain.Orders;
import com.jiejie.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao ordersDao;

    public List<Orders> findAll(Integer page, Integer size) {

        //分頁操作
        PageHelper.startPage(page, size);
        return ordersDao.findAll();
    }

    public Orders findById(String id) {
        return ordersDao.findById(id);
    }
}
