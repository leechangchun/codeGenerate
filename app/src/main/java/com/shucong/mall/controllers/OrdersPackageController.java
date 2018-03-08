package com.shucong.mall.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.shucong.mall.mapper.OrdersPackageMapper;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shucong.mall.bean.OrdersPackage;
import java.util.List;

@Controller
@RequestMapping("ordersPackage")
public class OrdersPackageController {

    @Autowired
    private OrdersPackageMapper ordersPackageMapper;

    @RequestMapping("list")
    @ResponseBody
    List<OrdersPackage> list(){
        return ordersPackageMapper.findAll();
    }
}