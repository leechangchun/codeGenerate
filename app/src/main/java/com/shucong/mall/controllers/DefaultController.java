package com.shucong.mall.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller("DefaultController")
public class DefaultController {

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    String home(Map<String,Object> model) {
        model.put("message", "hello world");
        return "hello";
    }
}
