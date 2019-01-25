package com.zl.value;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/**
 * @Author
 * @Description
 * @Date
 */

/*@ConfigurationProperties
@Component*/

@PropertySource(value = "classpath:application.properties")
@Configuration
public class Entity {

    @Value("${normal}")//普通字符串的注入
    private String normal;
    //value("${spelDefault.value:xxxx}")    可以指定默认值


    //@Value("#{systemProperties['os.name']}")// 注入系统属性
    private String systemPropertiesName;

    //@Value("#{T(java.lang.Math).random() * 100.0}")//注入表达式结果
    private String randomNumber;

    @Value("${username}")
    private String username;

    //@Value("")注入资源
    private Resource resource;

    public String getNormal() {
        return normal;
    }

    public void setNormal(String normal) {
        this.normal = normal;
    }

    public String getSystemPropertiesName() {
        return systemPropertiesName;
    }

    public void setSystemPropertiesName(String systemPropertiesName) {
        this.systemPropertiesName = systemPropertiesName;
    }

    public String getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(String randomNumber) {
        this.randomNumber = randomNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "normal='" + normal + '\'' +
                ", systemPropertiesName='" + systemPropertiesName + '\'' +
                ", randomNumber='" + randomNumber + '\'' +
                ", username='" + username + '\'' +
                ", resource=" + resource +
                '}';
    }
}
