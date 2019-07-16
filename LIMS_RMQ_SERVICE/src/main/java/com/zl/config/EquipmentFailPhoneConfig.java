package com.zl.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EquipmentFailPhoneConfig {

    @Value("${spring.phone.equipmentFail.templateId}")
    private int templateId;

    public int getTemplateId() {
        return templateId;
    }

    public void setTemplateId(int templateId) {
        this.templateId = templateId;
    }
}
