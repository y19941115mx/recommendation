package com.ymx.recommendation.common;

import lombok.Data;

@Data
public class CommonException extends Exception {

    private String code;

    public CommonException(String message, String code) {
        super(message);
        this.code = code;
    }

    public CommonException(ErrorEnum errorEnum) {
        this(errorEnum.getMsg(), errorEnum.getCode());
    }
}
