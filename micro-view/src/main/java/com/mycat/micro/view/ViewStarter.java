package com.mycat.micro.view;

import org.springframework.boot.SpringApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Desc:view服务的启动类
 *
 * @date: 25/06/2017
 * @author: gaozhiwen
 */
@EnableCaching
@EnableFeignClients
@EnableRedisHttpSession
@SpringCloudApplication
public class ViewStarter extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new SecurityInterceptor()).excludePathPatterns("/", "/login").addPathPatterns("/**");
//        super.addInterceptors(registry);
    }

    public static void main(String[] args) {
        SpringApplication.run(ViewStarter.class, args);
    }
}
