package com.zl.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zl.myservlet.MyServlet;

@Configuration
public class MyServletConfig {
	//注冊自定义servlet
	//@Bean
	public ServletRegistrationBean myServlet() {
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new MyServlet());
		return servletRegistrationBean;
	}
}
