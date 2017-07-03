package com.mycat.micro.gateway.controller;

import com.mycat.micro.gateway.constant.Constants;
import com.mycat.micro.gateway.model.Result;
import com.mycat.micro.gateway.model.ResultEnum;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Desc:
 *
 * @date: 28/06/2017
 * @author: gaozhiwen
 */
@RestController
public class SessionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SessionController.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/session/token")
    public Result checkToken(String sessionId) {
        Result result = null;
        LOGGER.info("gateway session id for jsessionid: {}", sessionId);
        String sessionToken = (String) redisTemplate.opsForHash().get(sessionId, Constants.REDIS_KEY_ACCOUNT);
//        HttpSession session = request.getSession();
//        LOGGER.info("session id: {}", session.getId());
//        String sessionToken = (String) session.getAttribute("loginAccount");
        if (StringUtils.isEmpty(sessionToken)) {
            result = new Result(ResultEnum.NOT_LOGIN);
        } else {
            result = new Result(ResultEnum.SUCCESS);
        }
        return result;
    }
}
