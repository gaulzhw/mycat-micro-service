package com.mycat.micro.gateway.config;

import com.mycat.micro.gateway.filter.LoginPostFilter;
import com.mycat.micro.gateway.filter.SecurityPreFilter;
import com.netflix.zuul.ZuulFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Desc:
 *
 * @date: 02/07/2017
 * @author: gaozhiwen
 */
@Configuration
public class FilterConfig {
    @Bean
    public ZuulFilter securityPreFilter() {
        return new SecurityPreFilter();
    }

    @Bean
    public ZuulFilter loginPostFilter() {
        return new LoginPostFilter();
    }
}
