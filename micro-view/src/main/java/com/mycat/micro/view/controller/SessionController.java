package com.mycat.micro.view.controller;

import com.mycat.micro.view.model.Result;
import com.mycat.micro.view.service.SessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Desc:
 *
 * @date: 25/06/2017
 * @author: gaozhiwen
 */
@RestController
public class SessionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SessionController.class);

    @Autowired
    private SessionService sessionService;

    @GetMapping("/session/token")
    public Result tokenCheck(@CookieValue("JSESSIONID") String sessionId) {
        LOGGER.info("session to check token");
        Result result = sessionService.tokenCheck(sessionId);
        LOGGER.info("session check result: {}", result);
        return result;
    }
}
