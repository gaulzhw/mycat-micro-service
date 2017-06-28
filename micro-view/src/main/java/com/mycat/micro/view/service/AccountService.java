package com.mycat.micro.view.service;

import com.mycat.micro.view.model.Account;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Desc:
 *
 * @date: 25/06/2017
 * @author: gaozhiwen
 */
@FeignClient(name = "micro-gateway", fallback = AccountService.HystrixAccountService.class)
public interface AccountService {
    @GetMapping("/account/login")
    Account login(@RequestParam("username") String username, @RequestParam("password") String password);

    @Component
    class HystrixAccountService implements AccountService {
        @Override
        public Account login(String username, String password) {
            Account account = new Account();
            account.setName("mock");
            account.setPassword("mock");
            return account;
        }
    }
}
