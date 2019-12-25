package com.ymx.recommendation.config;

import com.ymx.recommendation.interceptor.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: recommendation
 * @description: 拦截器配置
 * @author: victor
 * @create: 2019-12-25 18:10
 **/
@Configuration
public class IntercetporConfig implements WebMvcConfigurer {
    @Autowired
    JwtInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/api/user/login")
                .excludePathPatterns("/api/user/register");
    }
}
