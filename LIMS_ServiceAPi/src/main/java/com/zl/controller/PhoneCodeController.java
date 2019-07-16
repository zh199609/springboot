package com.zl.controller;

import com.zl.bean.PhoneCode;
import com.zl.common.response.ResponseMessage;
import com.zl.service.PhoneCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "手机验证码API")
@RequestMapping(value = "/phoneCode")
//http://localhost:8080/api/swagger-ui.html#/
@CrossOrigin
public class PhoneCodeController {

    @Autowired
    private PhoneCodeService phoneCodeService;


    @RequestMapping(value = "/sendMockCode/{phoneNumber}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "mock发送手机验证码", notes = "发送手机验证码(mock)",httpMethod="GET")
    public ResponseMessage sendMockCode(@ApiParam(value = "手机号码", required = true) @PathVariable(value = "phoneNumber") String phoneNumber) {
        return phoneCodeService.mockSendCode(phoneNumber);
    }

    @RequestMapping(value = "/sendCode/{phoneNumber}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "发送手机验证码(真实)", notes = "发送手机验证码(prod)",httpMethod="GET")
    public ResponseMessage sendCode(@ApiParam(value = "手机号码", required = true) @PathVariable(value = "phoneNumber") String phoneNumber) {
        return phoneCodeService.sendCode(phoneNumber);
    }



    @RequestMapping("/verifyCode/{phoneNumber}/{phoneCode}")
    @ApiOperation(value = "校验手机验证码", notes = "校验手机验证码")
    public ResponseMessage verifyCode(@ApiParam(value = "手机号码", required = true)@PathVariable(value = "phoneNumber") String phoneNumber
            , @ApiParam(value = "验证码", required = true)@PathVariable(value = "phoneCode") String phoneCode) {
        return phoneCodeService.verifyPhoneCode(phoneNumber, phoneCode);
    }


    @RequestMapping(value = "/getCode/{phoneNumber}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取手机验证码", notes = "根据手机号获验证码")
    public PhoneCode getCodeByPhone(@ApiParam(value = "手机号码", required = true) @PathVariable(value = "phoneNumber") String phoneNumber) {
        return phoneCodeService.getPhoneCode(phoneNumber);
    }
}
