package com.ymx.recommendation.interceptor;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.ymx.recommendation.common.CommonException;
import com.ymx.recommendation.common.ErrorEnum;
import com.ymx.recommendation.common.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: recommendation
 * @description: Jwt 拦截器
 * @author: victor
 * @create: 2019-12-25 18:12
 **/

@Component
public class JwtInterceptor implements HandlerInterceptor {
    @Autowired
    JwtHelper jwtHelper;
    @Value("${jwt.token-header}")
    String tokenHeader;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(tokenHeader);
        if (token == null) {
            throw new CommonException(ErrorEnum.TOKEN_FAILED);
        }
        Long uid = jwtHelper.validate(token);
        request.setAttribute("userId", uid);
        return true;
    }
}
