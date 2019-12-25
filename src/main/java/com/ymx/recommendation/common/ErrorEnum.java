package com.ymx.recommendation.common;


public enum ErrorEnum {
    /**
     * 操作成功
     */
    SUCCESS("0", "success"),
    /**
     * 系统内部错误
     */
    UNKNOWN_ERR("-1", "未知错误"),
    /**
     * 请求参数验证失败
     */
    VALID_ERR("10000", "验证失败"),
    /**
     * 请求路径出错
     */
    NOT_FOUND("40000", "资源不存在");

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
