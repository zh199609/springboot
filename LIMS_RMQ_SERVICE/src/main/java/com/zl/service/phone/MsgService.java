package com.zl.service.phone;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.zl.config.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsgService {

    @Autowired
    private PhoneConfig phoneConfig;

    @Autowired
    private RoomPhoneSuccessConfig roomPhoneSuccessConfig;

    @Autowired
    private RoomPhoneFailConfig roomPhoneFailConfig;

    @Autowired
    private EquipmentSuccessPhoneConfig equipmentSuccessPhoneConfig;

    @Autowired
    private EquipmentFailPhoneConfig equipmentFailPhoneConfig;

    @Autowired
    private SmsSingleSender ssender;

    public void sendRoom(String[] params, String phoneNumber, boolean statuis) {
        SmsSingleSenderResult result = null;
        try {
            if (statuis && params.length == 3) {
                result = ssender.sendWithParam("86", phoneNumber,
                        roomPhoneSuccessConfig.getTemplateId(), params, phoneConfig.getSmsSign(), "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
                System.out.println(phoneNumber + "--实验室教室预约成功短信发送状态：" + result);
            } else if (statuis == false && params.length == 2) {
                result = ssender.sendWithParam("86", phoneNumber,
                        roomPhoneFailConfig.getTemplateId(), params, phoneConfig.getSmsSign(), "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
                System.out.println(phoneNumber + "--实验室教室预约失败短信发送状态：" + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(phoneNumber + "--实验室教室预约短信发送失败。。。。。");
        }
    }

    public void sendEquipment(String[] params, String phoneNumber, boolean statuis) {
        SmsSingleSenderResult result = null;
        try {
            if (statuis && params.length == 3) {
                result = ssender.sendWithParam("86", phoneNumber,
                        equipmentSuccessPhoneConfig.getTemplateId(), params, phoneConfig.getSmsSign(), "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
                System.out.println(phoneNumber + "--设备借用成功短信发送状态：" + result);
            } else if (statuis == false && params.length == 2) {
                result = ssender.sendWithParam("86", phoneNumber,
                        equipmentFailPhoneConfig.getTemplateId(), params, phoneConfig.getSmsSign(), "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
                System.out.println(phoneNumber + "--设备预约失败短信发送状态：" + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(phoneNumber + "--设备借用短信发送失败。。。。。");
        }
    }


}
