package com.ymx.recommendation.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;


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
        } else if(ex instanceof NoHandlerFoundException) {
            return  CommonRes.fail(ErrorEnum.NOT_FOUND.getCode(), ErrorEnum.NOT_FOUND.getMsg());
        } else {
            log.error("err:", ex);
            return CommonRes.fail(ErrorEnum.UNKNOWN_ERR.getCode(), ErrorEnum.UNKNOWN_ERR.getMsg());
        }
    }
}
