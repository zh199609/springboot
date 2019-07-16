package com.zl.service;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.zl.bean.PhoneCode;
import com.zl.common.response.ResponseMessage;
import com.zl.config.PhoneConfig;
import com.zl.config.redis.RedisBean;
import com.zl.resEnum.PhoneCodeEnum;
import com.zl.util.CodeUtil;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PhoneCodeService {

    @Autowired
    private PhoneConfig phoneConfig;

    @Autowired
    private RedisBean redisBean;


    public PhoneCode getPhoneCode(String phoneNumber) {
        PhoneCode phoneCode = new PhoneCode();
        phoneCode.setPhoneNumber(phoneNumber);
        if (!verifyPhone(phoneNumber)) {
            phoneCode.setResultCode(PhoneCodeEnum.FAIL.getCode());
            phoneCode.setResultMsg(PhoneCodeEnum.FAIL.getMsg());
            return phoneCode;
        }
        Object redisPhoneCode = redisBean.Get(phoneNumber);
        if (redisPhoneCode == null) {
            phoneCode.setResultCode(PhoneCodeEnum.FAIL.getCode());
            phoneCode.setResultMsg(PhoneCodeEnum.FAIL.getMsg());
            return phoneCode;
        }
        phoneCode.setPhoneCode(redisPhoneCode.toString());
        phoneCode.setResultCode(PhoneCodeEnum.SUCCESS.getCode());
        phoneCode.setResultMsg(PhoneCodeEnum.SUCCESS.getMsg());
        return phoneCode;
    }


    public ResponseMessage mockSendCode(String phoneNumber) {
        String currentPhoneCode = CodeUtil.getCode();
        try {
            redisBean.Add(phoneNumber, currentPhoneCode, 30);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseMessage.createRes(PhoneCodeEnum.FAIL.getCode(), PhoneCodeEnum.FAIL.getMsg());
        }
        return ResponseMessage.createRes(PhoneCodeEnum.SUCCESS.getCode(), PhoneCodeEnum.SUCCESS.getMsg());
    }

    public ResponseMessage sendCode(String phoneNumber) {
        SmsSingleSenderResult result = null;
        String code = CodeUtil.getCode();
        try {
            String[] params = {code, phoneConfig.getExpire()};//数组具体的元素个数和模板中变量个数必须一致，例如事例中templateId:5678对应一个变量，参数数组中元素个数也必须是一个
            SmsSingleSender ssender = new SmsSingleSender(phoneConfig.getAddId(), phoneConfig.getAppKey());
            result = ssender.sendWithParam("86", phoneNumber,
                    phoneConfig.getTemplateId(), params, phoneConfig.getSmsSign(), "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
            System.out.println(result);
        } catch (Exception e) {
            // HTTP响应码错误
            e.printStackTrace();
        } finally {
            if (result.result == 0) {
                redisBean.Add(phoneNumber, code, 30);
                return ResponseMessage.createRes(PhoneCodeEnum.SUCCESS.getCode(), PhoneCodeEnum.SUCCESS.getMsg());
            } else {
                return ResponseMessage.createRes(PhoneCodeEnum.FAIL.getCode(), PhoneCodeEnum.FAIL.getMsg());
            }
        }


    }

    public ResponseMessage verifyPhoneCode(String phoneNumber, String phoneCode) {
        if (StringUtils.isBlank(phoneNumber) || StringUtils.isBlank(phoneCode) || phoneNumber.length() != 11 || phoneCode.length() != 4) {
            return ResponseMessage.createRes(PhoneCodeEnum.FAIL.getCode(), PhoneCodeEnum.FAIL.getMsg());
        }
        Object redisPhoneCode = redisBean.Get(phoneNumber);
        if (redisPhoneCode == null || !redisPhoneCode.equals(phoneCode)) {
            return ResponseMessage.createRes(PhoneCodeEnum.FAIL.getCode(), PhoneCodeEnum.FAIL.getMsg());
        }
        return ResponseMessage.createRes(PhoneCodeEnum.SUCCESS.getCode(), PhoneCodeEnum.SUCCESS.getMsg());
    }

    public boolean verifyPhone(String phone) {
        if (StringUtils.isBlank(phone)) {
            return false;
        }
        if (phone.length() != 11) {
            return false;
        }
        return true;
    }
}
