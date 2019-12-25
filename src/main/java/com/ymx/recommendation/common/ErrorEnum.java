package com.ymx.recommendation.common;


public enum ErrorEnum {
    /**
     * 系统内部错误
     */
    UNKNOWN_ERR("10000", "未知错误"),
    /**
     * 请求参数验证失败
     */
    VALID_ERR("10001", "验证失败"),
    /**
     * 请求路径出错
     */
    NOT_FOUND("10002", "资源不存在"),

    /**
     *  token 过期
     */
    TOKEN_EXPIRED("20000", "token 失效"),

    /**
     * toeken 验证失败
     */
    TOKEN_FAILED("20001", "token 验证失败"),

    /**
     * 登录验证失败
     */
    LOGIN_FALIED("20002", "手机号或密码错误"),
    /**
     * 手机号已存在
     */
    PHONE_DUPLICATED("20003", "手机号已注册")

    ;


    private String code;
    private String msg;

    ErrorEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
