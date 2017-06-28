package com.mycat.micro.view.controller;

import com.mycat.micro.view.model.Account;
import com.mycat.micro.view.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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

    @PostMapping("/login")
    public String login(String username, String password, HttpServletRequest request) {
        LOGGER.info("[login] param username: {}, password: {}", username, password);
        Account account = null;
        try {
            account = accountService.login(username, password);
        } catch (RuntimeException e) {
            LOGGER.error("[login] account service login error, perhaps eureka error", e);
        }
        return "success";
    }
}
