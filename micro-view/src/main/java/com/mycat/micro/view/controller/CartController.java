package com.mycat.micro.view.controller;

import com.mycat.micro.view.model.CartRecord;
import com.mycat.micro.view.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Integer cart(CartRecord record) {
        record.setTime(new Date());
        return cartService.add(record);
    }

    @GetMapping("/cart/records")
    public List<CartRecord> getCartRecords(@CookieValue("SESSION") String sessionId) {
        return cartService.getCartRecords("SESSION=" + sessionId);
    }
}
