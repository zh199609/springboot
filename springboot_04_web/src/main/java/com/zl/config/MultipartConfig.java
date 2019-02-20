package com.zl.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @Author
 * @Description
 * @Date
 */
@Configuration
public class MultipartConfig {
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxInMemorySize(1000000);
        return commonsMultipartResolver;
    }
}
