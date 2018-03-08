package com.shucong.mall.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.shucong.mall.mapper.ProductAttributesMapper;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shucong.mall.bean.ProductAttributes;
import java.util.List;

@Controller
@RequestMapping("productAttributes")
public class ProductAttributesController {

    @Autowired
    private ProductAttributesMapper productAttributesMapper;

    @RequestMapping("list")
    @ResponseBody
    List<ProductAttributes> list(){
        return productAttributesMapper.findAll();
    }
}