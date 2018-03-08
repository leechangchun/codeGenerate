package com.shucong.mall.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.shucong.mall.mapper.OrdersPackageDetailMapper;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shucong.mall.bean.OrdersPackageDetail;
import java.util.List;

@Controller
@RequestMapping("ordersPackageDetail")
public class OrdersPackageDetailController {

    @Autowired
    private OrdersPackageDetailMapper ordersPackageDetailMapper;

    @RequestMapping("list")
    @ResponseBody
    List<OrdersPackageDetail> list(){
        return ordersPackageDetailMapper.findAll();
    }
}