package com.mycat.micro.view.service;

import com.mycat.micro.view.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Desc:
 *
 * @date: 25/06/2017
 * @author: gaozhiwen
 */
@FeignClient(name = "micro-gateway", fallback = SessionService.HystrixSessionService.class)
public interface SessionService {
    Logger LOGGER = LoggerFactory.getLogger(SessionService.class);

    @RequestMapping(value = "/session/token")
    Result tokenCheck(@RequestParam("sessionId") String sessionId);

    @Component
    class HystrixSessionService implements SessionService {
        @Override
        public Result tokenCheck(String sessionId) {
            LOGGER.warn("token check error");
            return new Result(402, "server error");
        }
    }
}
