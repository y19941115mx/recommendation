package com.ymx.recommendation.config;

import com.ymx.recommendation.common.JwtHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: recommendation
 * @description: JWT配置类
 * @author: victor
 * @create: 2019-12-25 16:43
 **/
@Configuration
public class JwtConfig {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expire}")
    private long expire;

    @Bean
    public JwtHelper jwtHelperBean() {
        return new JwtHelper(secret, expire * 60 * 1000 );
    }
}
