package com.ymx.recommendation.common;


public enum ErrorEnum {

    SUCCESS("0", "success"),
    UNKNOWN_ERR("-1", "未知错误"),
    VALID_ERR("10000", ""),
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
