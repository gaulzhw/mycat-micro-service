package com.mycat.micro.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Desc:服务启动类
 *
 * @date: 11/06/2017
 * @author: gaozhiwen
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaStarter {
    public static void main(String[] args) {
        SpringApplication.run(EurekaStarter.class, args);
    }
}
