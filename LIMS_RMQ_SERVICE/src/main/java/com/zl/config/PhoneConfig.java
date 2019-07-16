package com.zl.config;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PhoneConfig {

    @Value("${spring.phone.addId}")
    private int addId;
    @Value("${spring.phone.appKey}")
    private String appKey;
    @Value("${spring.phone.smsSign}")
    private String smsSign;

    public int getAddId() {
        return addId;
    }

    public void setAddId(int addId) {
        this.addId = addId;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getSmsSign() {
        return smsSign;
    }

    public void setSmsSign(String smsSign) {
        this.smsSign = smsSign;
    }


    @Bean
    public SmsSingleSender createSmsSingleSender() {
        return new SmsSingleSender(getAddId(), getAppKey());
    }


}
