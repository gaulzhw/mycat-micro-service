package com.mycat.micro.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Desc: 服务启动类
 *
 * @date: 24/06/2017
 * @author: gaozhiwen
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AccountStarter {
    public static void main(String[] args) {
        SpringApplication.run(AccountStarter.class, args);
    }
}
