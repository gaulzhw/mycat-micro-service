package com.mycat.micro.account.service;

import com.mycat.micro.account.mapper.AccountMapper;
import com.mycat.micro.account.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private AccountMapper accountMapper;

    public Account login(String username, String password) {
        LOGGER.info("account login, username: {}, password: {}", username, password);
        return accountMapper.getAccountByNameAndPwd(username, password);
    }
}
