package com.mycat.micro.gateway.filter;

import com.mycat.micro.gateway.constant.Constants;
import com.mycat.micro.gateway.model.Account;
import com.mycat.micro.gateway.util.JacksonUtil;
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
        String uri = getContext().getRequest().getRequestURI();
        return uri.startsWith("/cart/");
    }

    @Override
    public Object run() {
        LOGGER.info("security pre filter");
        HttpSession session = getContext().getRequest().getSession();
        String accountStr = (String) session.getAttribute(Constants.SESSION_KEY_ACCOUNT);
        Account account = JacksonUtil.decode(accountStr, Account.class);
        if (account != null) {
            getContext().addZuulRequestHeader("accountName", account.getName());
        }
        LOGGER.info("session id: {}", session.getId());
        return null;
    }

    private RequestContext getContext() {
        return RequestContext.getCurrentContext();
    }
}
