package com.mycat.micro.cart.controller;

import com.mycat.micro.cart.model.CartRecord;
import com.mycat.micro.cart.service.CartService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Desc:
 *
 * @date: 27/06/2017
 * @author: gaozhiwen
 */
@RestController
public class CartController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

    @Autowired
    private CartService cartService;

    @GetMapping("/records")
    public List<CartRecord> getProductsByUsername(HttpServletRequest request) {
        String name = request.getHeader("accountName");
        return cartService.getProductsByUsername(name);
    }

    @PostMapping("/records")
    public Integer addProductToCart(CartRecord cartRecord, HttpServletRequest request) {
        String name = request.getHeader("accountName");
        cartRecord.setUsername(name);
        return cartService.addProductToCart(cartRecord);
    }
}
