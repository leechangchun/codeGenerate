package com.shucong.mall.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.shucong.mall.mapper.ProductSkuMapper;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shucong.mall.bean.ProductSku;
import java.util.List;

@Controller
@RequestMapping("productSku")
public class ProductSkuController {

    @Autowired
    private ProductSkuMapper productSkuMapper;

    @RequestMapping("list")
    @ResponseBody
    List<ProductSku> list(){
        return productSkuMapper.findAll();
    }
}