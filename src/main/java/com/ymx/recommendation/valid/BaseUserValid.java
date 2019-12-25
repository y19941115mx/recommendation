package com.ymx.recommendation.valid;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @program: recommendation
 * @description: 用户验证基类
 * @author: victor
 * @create: 2019-12-25 19:37
 **/
@Data
public class BaseUserValid {
    @NotBlank(message = "电话号码不能为空")
    protected String phone;
    @NotBlank(message = "密码不能为空")
    protected String password;
}
