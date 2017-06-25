package com.mycat.micro.account.controller;

import com.mycat.micro.account.model.Account;
import com.mycat.micro.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Desc:对外暴露的接口
 *
 * @date: 24/06/2017
 * @author: gaozhiwen
 */
@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/login")
    public Account login(String username, String password){
        System.out.println("account login");
        return accountService.login(username, password);
    }
}
