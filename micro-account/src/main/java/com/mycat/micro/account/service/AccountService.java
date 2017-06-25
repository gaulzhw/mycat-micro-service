package com.mycat.micro.account.service;

import com.mycat.micro.account.model.Account;
import org.springframework.stereotype.Service;

/**
 * Desc:
 *
 * @date: 25/06/2017
 * @author: gaozhiwen
 */
@Service
public class AccountService {
    public Account login(String username, String password) {
        Account account = new Account();
        account.setName(username);
        account.setPassword(password);
        return account;
    }
}
