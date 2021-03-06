package com.mycat.micro.view;

import com.mycat.micro.view.interceptor.SecurityInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Desc:view服务的启动类
 *
 * @date: 25/06/2017
 * @author: gaozhiwen
 */
@EnableFeignClients
@SpringCloudApplication
public class ViewStarter extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SecurityInterceptor())
                .excludePathPatterns("/", "/login.html", "/account/login", "/session/**", "/detail.html", "/products/**")
                .addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    public static void main(String[] args) {
        SpringApplication.run(ViewStarter.class, args);
    }
}
