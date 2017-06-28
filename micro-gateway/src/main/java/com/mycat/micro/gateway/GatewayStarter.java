package com.mycat.micro.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Desc: 服务启动类
 *
 * @date: 24/06/2017
 * @author: gaozhiwen
 */
@EnableZuulProxy
@EnableRedisHttpSession
@SpringCloudApplication
public class GatewayStarter {
    public static void main(String[] args) {
        SpringApplication.run(GatewayStarter.class, args);
    }
}
