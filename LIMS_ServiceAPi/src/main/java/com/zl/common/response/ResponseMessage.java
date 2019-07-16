package com.zl.common.response;

import java.io.Serializable;

public class ResponseMessage implements Serializable {

    private static final long serialVersionUID = -772069004168139886L;
    //状态码
    private String code;
    //消息
    private String msg;

    public static ResponseMessage createRes(String code, String msg) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setCode(code);
        responseMessage.setMsg(msg);
        return responseMessage;
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
