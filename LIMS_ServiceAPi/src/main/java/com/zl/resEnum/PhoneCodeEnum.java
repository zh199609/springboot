package com.zl.resEnum;

public enum PhoneCodeEnum {

    SUCCESS("1000", "ok"),
    FAIL("1001", "fail");
    private String code;
    private String msg;

    PhoneCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
