package com.ymx.recommendation.common;

import lombok.Data;

@Data
public class CommonRes {
    private int code;
    private Object data;
    private String msg;

    public static CommonRes success(Object object) {
        CommonRes res = new CommonRes();
        res.setCode(0);
        res.setMsg("success");
        res.setData(object);
        return res;
    }
    public static CommonRes success() {
        return CommonRes.success(null);
    }

    public static CommonRes fail(int code, String msg) {
        CommonRes res = new CommonRes();
        res.setCode(code);
        res.setMsg(msg);
        res.setData(null);
        return res;
    }
}
