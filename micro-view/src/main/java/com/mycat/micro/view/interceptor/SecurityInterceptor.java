package com.mycat.micro.view.interceptor;

import com.google.common.collect.Maps;
import com.mycat.micro.view.constant.Constants;
import com.mycat.micro.view.model.Result;
import com.mycat.micro.view.service.SessionService;
import com.mycat.micro.view.util.JacksonUtil;
import com.mycat.micro.view.util.SpringContextUtil;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Desc:
 *
 * @date: 06/07/2017
 * @author: gaozhiwen
 */
public class SecurityInterceptor implements HandlerInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityInterceptor.class);
    private static final String REDIRECT_PAGE = "/login.html";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        if (ArrayUtils.isEmpty(cookies)) {
            setResult(response, REDIRECT_PAGE);
            return false;
        }

        Optional<Cookie> opt = Stream.of(cookies)
                .filter(cookie -> cookie != null && Constants.SESSION.equals(cookie.getName()))
                .findFirst();

        if (opt.isPresent()) {
            Cookie cookie = opt.get();
            String sessionId = cookie.getValue();
            SessionService sessionService = SpringContextUtil.getBean(SessionService.class);
            try {
                Result sessionResult = sessionService.tokenCheck("SESSION=" + sessionId);
                if (sessionResult != null && sessionResult.getCode() == Constants.RESULT_SUCCESS) {
                    return true;
                }
            } catch (Exception e) {
                LOGGER.warn("check token error", e);
            }
        }

        setResult(response, REDIRECT_PAGE);
        return false;
    }

    private void setResult(HttpServletResponse response, String url) throws ServletException, IOException {
        Map<String, String> map = Maps.newHashMapWithExpectedSize(1);
        map.put("redirect", url);
        response.getWriter().print(JacksonUtil.encode(map));
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
