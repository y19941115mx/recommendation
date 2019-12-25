package com.ymx.recommendation.service;

import com.ymx.recommendation.common.CommonException;
import com.ymx.recommendation.model.entity.User;
import com.ymx.recommendation.valid.LoginValid;
import com.ymx.recommendation.valid.RegisterValid;

/**
 * @program: recommendation
 * @description: 用户服务
 * @author: victor
 * @create: 2019-12-25 16:25
 **/
public interface UserService {
    /**
     * 登录接口
     * @param loginValid 登录参数验证
     * @return toekn值
     * @throws CommonException
     */
     String login(LoginValid loginValid) throws CommonException;

    /**
     * 注册接口
     * @param registerValid 表单参数
     * @return 注册成功的User实体
     * @throws CommonException
     */
    User register(RegisterValid registerValid) throws CommonException;
}
