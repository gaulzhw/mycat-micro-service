package com.mycat.micro.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Desc: 服务启动类
 *
 * @date: 24/06/2017
 * @author: gaozhiwen
 */
@EnableZuulProxy
@SpringCloudApplication
public class GatewayStarter {
    public static void main(String[] args) {
        SpringApplication.run(GatewayStarter.class, args);
    }
}