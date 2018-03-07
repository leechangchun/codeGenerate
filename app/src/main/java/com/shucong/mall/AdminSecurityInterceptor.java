package com.shucong.mall;

import com.shucong.mall.bean.Admin;
import com.shucong.mall.bean.SysRolePermission;
import com.shucong.mall.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author blueriver
 * @description 权限拦截器
 * @date 2017/11/17
 * @since 1.0
 */
public class AdminSecurityInterceptor implements HandlerInterceptor {

    @Autowired
    private AdminUserService adminUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 验证权限
        if (this.hasPermission(handler, request.getSession())) {
            return true;
        }
        //  null == request.getHeader("x-requested-with") TODO 暂时用这个来判断是否为ajax请求
        // 如果没有权限 则抛403异常 springboot会处理，跳转到 /error/403 页面
        response.sendError(HttpStatus.FORBIDDEN.value(), "无权限");
        return false;
    }

    /**
     * 是否有权限
     * @param handler
     * @param httpSession
     * @return
     */
    private boolean hasPermission(Object handler, HttpSession httpSession) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            // 获取方法上的注解
            AdminPermission requiredPermission = handlerMethod.getMethod().getAnnotation(AdminPermission.class);
            // 如果方法上的注解为空 则获取类的注解
            if (requiredPermission == null) {
                requiredPermission = handlerMethod.getMethod().getDeclaringClass().getAnnotation(AdminPermission.class);
            }
            // 如果标记了注解，则判断权限
            if (requiredPermission != null && !StringUtils.isEmpty(requiredPermission.value())) {
                //获取该用户的权限信息 并判断是否有权限
                Admin admin = (Admin) httpSession.getAttribute("admin");
                if (admin == null) {
                    return false;
                }
                List<SysRolePermission> permissionSets = adminUserService.getPermissionSet(admin.getId());
                if (CollectionUtils.isEmpty(permissionSets) ) {
                    return false;
                }
                for (SysRolePermission sysRolePermission : permissionSets) {
                    if (sysRolePermission.getPermission().equals(requiredPermission.value())) {
                        return true;
                    }
                }
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // TODO
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // TODO
    }
}