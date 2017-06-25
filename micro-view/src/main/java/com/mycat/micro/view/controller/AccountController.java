package com.mycat.micro.view.controller;

import com.mycat.micro.view.model.Account;
import com.mycat.micro.view.service.AccountService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Desc:
 *
 * @date: 25/06/2017
 * @author: gaozhiwen
 */
@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/login")
    public String login(String username, String password, HttpServletRequest request) {
        System.out.println(username);
        System.out.println(password);
        Account account = accountService.login(username, password);
        System.out.println("account: " + account);
        if (account == null) {
            return "index";
        } else {
            request.setAttribute("username", account.getName());
            return "welcome";
        }
    }
}
