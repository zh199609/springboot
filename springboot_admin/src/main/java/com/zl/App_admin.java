package com.zl;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class App_admin {

    public static void main(String[] args) {
        SpringApplication.run(App_admin.class,args);
    }
}
