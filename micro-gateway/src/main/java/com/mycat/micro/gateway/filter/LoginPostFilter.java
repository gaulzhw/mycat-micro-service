package com.mycat.micro.gateway.filter;

import com.google.common.base.Charsets;
import com.mycat.micro.gateway.constant.Constants;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;

/**
 * Desc:
 *
 * @date: 28/06/2017
 * @author: gaozhiwen
 */
public class LoginPostFilter extends ZuulFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginPostFilter.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        String uri = context.getRequest().getRequestURI();
        LOGGER.info("login post filter should filter, uri: {}", uri);
        if (uri.startsWith("/account/login")) {
            return true;
        }
        return false;
    }

    @Override
    public Object run() {
        LOGGER.info("security pre filter");

        RequestContext context = RequestContext.getCurrentContext();
        String result = null;

        if (context.getResponseBody() != null) {
            result = context.getResponseBody();
            LOGGER.info("result from response body: {}", result);
            context.setResponseBody(wrapResult(context, result));
        } else if (context.getResponseDataStream() != null) {
            InputStream is = context.getResponseDataStream();
            try {
                result = IOUtils.toString(is, Charsets.UTF_8.name());
                LOGGER.info("result from response data stream: {}", result);
                String tokenId = wrapResult(context, result);
                if (StringUtils.isNotEmpty(tokenId)) {
                    context.setResponseDataStream(IOUtils.toInputStream(tokenId));
                }
            } catch (IOException e) {
                LOGGER.error("error to handle io utils for charset utf-8");
            }
        }

        return null;
    }

    private String wrapResult(RequestContext context, String result) {
        String tokenId = null;
        if (StringUtils.isNotEmpty(result)) {
            HttpSession session = context.getRequest().getSession();
            tokenId = session.getId();
            redisTemplate.opsForHash().put(tokenId, Constants.REDIS_KEY_ACCOUNT, result);
//            session.setAttribute("loginAccount", result);
            LOGGER.info("login post filter result: {}, tokenId: {}", result, tokenId);
        }
        return tokenId;
    }
}
