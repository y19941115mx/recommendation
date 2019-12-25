package com.ymx.recommendation.valid;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @program: recommendation
 * @description: 注册参数验证
 * @author: victor
 * @create: 2019-12-25 16:30
 **/
@Data
public class RegisterValid extends BaseUserValid{
    private Integer gender;
    @NotBlank(message = "昵称不能为空")
    private String nickName;
}
