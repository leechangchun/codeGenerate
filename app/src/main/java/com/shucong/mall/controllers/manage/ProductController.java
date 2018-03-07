package com.shucong.mall.controllers.manage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller("MangeProductController")
@RequestMapping("manage")
public class ProductController {

    @RequestMapping("products")
    String list(Map<String, Object> model) {
        return "manage/product/list";
    }

    @RequestMapping("product/add")
    String add(Map<String, Object> model) {
        return "manage/product/add";
    }

}
