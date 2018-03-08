package com.shucong.mall.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.shucong.mall.mapper.OrdersMapper;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shucong.mall.bean.Orders;
import java.util.List;

@Controller
@RequestMapping("orders")
public class OrdersController {

    @Autowired
    private OrdersMapper ordersMapper;

    @RequestMapping("list")
    @ResponseBody
    List<Orders> list(){
        return ordersMapper.findAll();
    }
}