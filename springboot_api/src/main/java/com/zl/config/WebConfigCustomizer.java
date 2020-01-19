package com.zl.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @ClassName: CustomWebConfig
 * @Description: 自定以web配置
 * @Author: albertzh
 * @Create: 2019-10-17 16:11
 */
@Configuration
public class WebConfigCustomizer implements WebMvcConfigurer {


    @Override
    public void addFormatters(FormatterRegistry registry) {
        System.out.println(registry);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        System.out.println(converters);
    }
}
