package com.shucong.mall.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.shucong.mall.mapper.ProductAttributeValuesMapper;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shucong.mall.bean.ProductAttributeValues;
import java.util.List;

@Controller
@RequestMapping("productAttributeValues")
public class ProductAttributeValuesController {

    @Autowired
    private ProductAttributeValuesMapper productAttributeValuesMapper;

    @RequestMapping("list")
    @ResponseBody
    List<ProductAttributeValues> list(){
        return productAttributeValuesMapper.findAll();
    }
}