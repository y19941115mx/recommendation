package com.ymx.recommendation.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonRes doError(Exception ex){
        if (ex instanceof CommonException) {
            return CommonRes.fail(((CommonException) ex).getCode(), ex.getMessage());
        } else if (ex instanceof MethodArgumentNotValidException) {
            return CommonRes.fail(((MethodArgumentNotValidException) ex));
        } else {
            log.error("err:", ex);
            return CommonRes.fail(ErrorEnum.UNKNOWN_ERR.getCode(), ErrorEnum.UNKNOWN_ERR.getMsg());
        }
    }
}
