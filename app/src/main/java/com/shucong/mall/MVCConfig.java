package com.shucong.mall;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MVCConfig extends WebMvcConfigurerAdapter {
    @Bean
    public AdminSecurityInterceptor adminSecurityInterceptor() {
        return new AdminSecurityInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(adminSecurityInterceptor())
                .excludePathPatterns("/static/*")
                .excludePathPatterns("/error")
                .excludePathPatterns("/manage/login")
                .excludePathPatterns("/manage/logout")
                .addPathPatterns("/manage/**");
    }

}