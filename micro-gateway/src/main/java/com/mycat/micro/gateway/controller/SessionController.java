package com.mycat.micro.gateway.controller;

import com.mycat.micro.gateway.constant.Constants;
import com.mycat.micro.gateway.model.Result;
import com.mycat.micro.gateway.model.ResultEnum;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Desc:
 *
 * @date: 28/06/2017
 * @author: gaozhiwen
 */
@RestController
public class SessionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SessionController.class);

    @GetMapping("/session/token")
    public Result checkToken(HttpServletRequest request) {
        Result result = null;
        LOGGER.info("session: {}", request.getSession());
        String sessionToken = (String) request.getSession().getAttribute(Constants.SESSION_KEY_ACCOUNT);

        if (StringUtils.isEmpty(sessionToken)) {
            result = new Result(ResultEnum.NOT_LOGIN);
        } else {
            result = new Result(ResultEnum.SUCCESS);
        }
        return result;
    }
}
