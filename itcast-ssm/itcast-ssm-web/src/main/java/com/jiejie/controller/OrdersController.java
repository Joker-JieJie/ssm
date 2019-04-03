package com.jiejie.controller;

import com.github.pagehelper.PageInfo;
import com.jiejie.domain.Orders;
import com.jiejie.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {


    @Autowired
    private OrdersService ordersService;

/*    //查詢所有  未分頁
    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<Orders> orders = ordersService.findAll();
        model.addAttribute("ordersList", orders);

        return "orders-list";
    }*/

    //查詢所有 分頁
    @RequestMapping("/findAll")
    public String findAll(Model model, Integer page, Integer size) {

        List<Orders> orders = ordersService.findAll(page, size);
        PageInfo<Orders> info = new PageInfo<Orders>(orders);
        model.addAttribute("info", info);
        return "orders-page-list";
    }

    //訂單詳情
    @RequestMapping("/findById")
    public String findById(Model model, String id) {
        Orders orders = ordersService.findById(id);
        model.addAttribute("orders", orders);

        System.out.println(orders);

        return "orders-show";
    }

}
