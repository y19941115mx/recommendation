package com.ymx.recommendation.common;


public enum ErrorEnum {

    SUCCESS(0, "success"),
    UNKNOWN_ERR(-1, "未知错误"),
    TEST_ERR(10000, "自定义错误");

    private int code;
    private String msg;

    ErrorEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
