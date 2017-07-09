package com.mycat.micro.view.controller;

import com.mycat.micro.view.constant.Constants;
import com.mycat.micro.view.model.Result;
import com.mycat.micro.view.model.ResultEnum;
import com.mycat.micro.view.service.AccountService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Desc:
 *
 * @date: 25/06/2017
 * @author: gaozhiwen
 */
@RestController
public class AccountController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    @PostMapping("/account/login")
    public Result login(String username, String password, HttpServletResponse response) {
        LOGGER.info("[login] param username: {}, password: {}", username, password);
        Result result = null;
        try {
            String tokenId = accountService.login(username, password);
            if (StringUtils.isEmpty(tokenId)) {
                result = new Result(ResultEnum.ERROR);
            } else {
                result = new Result(ResultEnum.SUCCESS);
                Cookie cookie = new Cookie(Constants.SESSION, tokenId);
                cookie.setMaxAge(24 * 60 * 60);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        } catch (RuntimeException e) {
            LOGGER.error("[login] account service login error, perhaps eureka error", e);
            result = new Result(ResultEnum.ERROR);
        }
        return result;
    }
}
