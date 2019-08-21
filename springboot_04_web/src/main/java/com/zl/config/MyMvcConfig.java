package com.zl.config;

import com.zl.component.LoginHandlerInterceptor;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送请求  映射到页面
        registry.addViewController("/zhanglei/boot").setViewName("index");
    }

    /*@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/asserts/**").addResourceLocations("classpath:static/asserts/");
    }*/

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/main").setViewName("dashboard");
            }

           /* @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/", "/user/login");
            }*/
        };
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocalResolver();
    }


    @Override//Springboot已经做了静态资源映射
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/", "/user/login","/asserts/**");
    }

    /**
     * 嵌入式容器定制器
     * @return
     */
    //@Bean
    public ConfigurableServletWebServerFactory configurableServletWebServerFactory(){
    	TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
    	//tomcat.setPort(8088);
    	return tomcat;
    }

}
