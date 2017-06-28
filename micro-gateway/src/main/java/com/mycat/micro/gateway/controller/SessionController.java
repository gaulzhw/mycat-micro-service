package com.mycat.micro.gateway.controller;

import com.mycat.micro.gateway.model.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Desc:
 *
 * @date: 28/06/2017
 * @author: gaozhiwen
 */
@RestController
@RequestMapping("/session")
public class SessionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SessionController.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/token")
    public ResultBean checkToken(@CookieValue("JSESSIONID") String sessionId, HttpServletRequest request) {
        LOGGER.info("check token, sessionId: {}", sessionId);
        return ResultBean.SUCCESS;
    }
}
