package com.mycat.micro.cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Desc:
 *
 * @date: 27/06/2017
 * @author: gaozhiwen
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CartStarter {
    public static void main(String[] args) {
        SpringApplication.run(CartStarter.class, args);
    }
}
