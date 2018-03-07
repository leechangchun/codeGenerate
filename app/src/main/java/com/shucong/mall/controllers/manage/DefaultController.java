package com.shucong.mall.controllers.manage;

import com.shucong.mall.bean.Admin;
import com.shucong.mall.mapper.AdminMapper;
import com.shucong.mall.utils.DataResponse;
import com.shucong.mall.utils.SHA1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller("MangeDefaultController")
@RequestMapping("manage")
public class DefaultController {

    @Autowired
    private AdminMapper adminMapper;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    String login(Map<String, Object> model) {
        model.put("message", "login");
        return "manage/login";
    }

    @RequestMapping("login/post")
    @ResponseBody
    DataResponse loginPost(HttpServletRequest request, HttpSession httpSession) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.length() == 0) {
            return new DataResponse(1000, "用户名不能为空");
        }

        Admin admin = adminMapper.findByUsername(username);
        if (admin == null) {
            return new DataResponse(1000, "用户不存在");
        }
        if (!admin.getPassword().equals(SHA1.encode(password))) {
            return new DataResponse(1000, "密码不正确" + SHA1.encode(password));
        }

        httpSession.setAttribute("admin", admin);

        return new DataResponse(0, "登录成功");
    }


    @RequestMapping("/")
    String dashboard(Map<String, Object> model) {
        model.put("message", "login");
        return "manage/dashboard";
    }
}
