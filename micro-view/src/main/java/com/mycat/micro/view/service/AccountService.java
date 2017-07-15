package com.mycat.micro.view.service;

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
public interface AccountService
{
	@GetMapping("/account/login")
	String login(@RequestParam("username") String username, @RequestParam("password") String password);

	@Component
	class HystrixAccountService implements AccountService
	{
		@Override
		public String login(String username, String password)
		{
			//触发熔断，做响应处理，可以返回默认值
			return null;
		}
	}
}
