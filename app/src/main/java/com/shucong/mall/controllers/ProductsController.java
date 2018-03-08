package com.shucong.mall.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.shucong.mall.mapper.ProductsMapper;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shucong.mall.bean.Products;
import java.util.List;

@Controller
@RequestMapping("products")
public class ProductsController {

    @Autowired
    private ProductsMapper productsMapper;

    @RequestMapping("list")
    @ResponseBody
    List<Products> list(){
        return productsMapper.findAll();
    }
}