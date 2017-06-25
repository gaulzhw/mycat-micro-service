package com.mycat.micro.view;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Desc:view服务的启动类
 *
 * @date: 25/06/2017
 * @author: gaozhiwen
 */
@EnableFeignClients
@SpringCloudApplication
public class ViewStarter {
    public static void main(String[] args) {
        SpringApplication.run(ViewStarter.class, args);
    }
}
