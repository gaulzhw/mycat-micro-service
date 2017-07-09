package com.mycat.micro.view.controller;

import com.mycat.micro.view.constant.Constants;
import com.mycat.micro.view.model.CartRecord;
import com.mycat.micro.view.model.Result;
import com.mycat.micro.view.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Desc:
 *
 * @date: 01/07/2017
 * @author: gaozhiwen
 */
@RestController
public class CartController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

    @Autowired
    private CartService cartService;

    @PostMapping("/cart/records")
    public Result cart(@RequestBody CartRecord record, @CookieValue(Constants.SESSION) String sessionId) {
        record.setTime(new Date());
        return cartService.add(record, "SESSION=" + sessionId);
    }

    @GetMapping("/cart/records")
    public List<CartRecord> getCartRecords(@CookieValue(Constants.SESSION) String sessionId) {
        return cartService.getCartRecords("SESSION=" + sessionId);
    }
}
