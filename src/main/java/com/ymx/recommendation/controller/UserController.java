package com.ymx.recommendation.controller;

import com.ymx.recommendation.common.CommonException;
import com.ymx.recommendation.common.CommonRes;
import com.ymx.recommendation.model.entity.User;
import com.ymx.recommendation.service.UserService;
import com.ymx.recommendation.valid.LoginValid;
import com.ymx.recommendation.valid.RegisterValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: recommendation
 * @description: 用户模块控制器
 * @author: victor
 * @create: 2019-12-25 20:35
 **/

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public CommonRes register(@Validated @RequestBody RegisterValid registerValid) throws CommonException {
        User user = userService.register(registerValid);
        return CommonRes.success(user);
    }

    @PostMapping("/login")
    public CommonRes login(@Validated @RequestBody LoginValid loginValid) throws CommonException {
        String token = userService.login(loginValid);
        return CommonRes.success(token);
    }
}
