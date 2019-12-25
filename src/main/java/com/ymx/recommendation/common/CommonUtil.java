package com.ymx.recommendation.common;

import org.springframework.util.DigestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.io.UnsupportedEncodingException;

public class CommonUtil {
    public static String processErrorString(BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(FieldError fieldError:bindingResult.getFieldErrors()){
            stringBuilder.append(fieldError.getField());
            stringBuilder.append(fieldError.getDefaultMessage()+"。");
        }
        return stringBuilder.substring(0,stringBuilder.length()-1);
    }

    public static String md5Encode(String word) {
        try {
            return DigestUtils.md5DigestAsHex(word.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
