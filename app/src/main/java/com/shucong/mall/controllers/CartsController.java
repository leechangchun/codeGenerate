package com.shucong.mall.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.shucong.mall.mapper.CartsMapper;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shucong.mall.bean.Carts;
import java.util.List;

@Controller
@RequestMapping("carts")
public class CartsController {

    @Autowired
    private CartsMapper cartsMapper;

    @RequestMapping("list")
    @ResponseBody
    List<Carts> list(){
        return cartsMapper.findAll();
    }
}