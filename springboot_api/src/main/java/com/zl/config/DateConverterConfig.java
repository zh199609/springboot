package com.zl.config;

import org.springframework.core.convert.converter.Converter;

import java.util.Date;

/**
 * @ClassName: DateConverterConfig
 * @Description: 自定义时间格式化
 * @Author: albertzh
 * @Create: 2019-10-17 16:14
 */
public class DateConverterConfig implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        return null;
    }
}
