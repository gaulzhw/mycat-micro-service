package com.mycat.micro.account.service;

import com.mycat.micro.account.mapper.AccountMapper;
import com.mycat.micro.account.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Desc:
 *
 * @date: 25/06/2017
 * @author: gaozhiwen
 */
@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;

    public Account login(String username, String password) {
        return accountMapper.getAccountByNameAndPwd(username, password);
    }
}
