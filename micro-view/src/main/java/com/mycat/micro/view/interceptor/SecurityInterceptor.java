package com.mycat.micro.view.interceptor;

import com.mycat.micro.view.constant.ViewConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Desc:
 *
 * @date: 25/06/2017
 * @author: gaozhiwen
 */
public class SecurityInterceptor implements HandlerInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj)
            throws Exception {
        LOGGER.debug("[security] pre");
        Object accountObj = request.getSession().getAttribute(ViewConstant.SESSION_KEY);
        if(accountObj == null) {
            LOGGER.warn("account is not login, redirect to login");
            response.sendRedirect(request.getContextPath());
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj,
            ModelAndView modelAndView) throws Exception {
        LOGGER.debug("[security] post");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj,
            Exception e) throws Exception {
        LOGGER.debug("[security] complete");
    }
}
