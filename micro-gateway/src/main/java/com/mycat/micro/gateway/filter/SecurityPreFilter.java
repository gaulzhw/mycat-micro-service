package com.mycat.micro.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpSession;

/**
 * Desc:
 *
 * @date: 28/06/2017
 * @author: gaozhiwen
 */
public class SecurityPreFilter extends ZuulFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityPreFilter.class);

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return -100;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        LOGGER.info("security pre filter");
        RequestContext context = RequestContext.getCurrentContext();
        HttpSession session = context.getRequest().getSession();
        LOGGER.info("session id: {}", session.getId());
        return null;
    }
}
