package com.ymx.recommendation.common;

import lombok.Data;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Data
public class CommonRes {
    private String code;
    private Object data;
    private String msg;

    public static CommonRes success(Object object) {
        CommonRes res = new CommonRes();
        res.setCode("0");
        res.setMsg("success");
        res.setData(object);
        return res;
    }
    public static CommonRes success() {
        return CommonRes.success(null);
    }

    public static CommonRes fail(String  code, String msg) {
        CommonRes res = new CommonRes();
        res.setCode(code);
        res.setMsg(msg);
        res.setData(null);
        return res;
    }

    public static  CommonRes fail(MethodArgumentNotValidException exp) {
        return CommonRes.fail(ErrorEnum.VALID_ERR.getCode(), CommonUtil.processErrorString(exp.getBindingResult()));
    }
}
