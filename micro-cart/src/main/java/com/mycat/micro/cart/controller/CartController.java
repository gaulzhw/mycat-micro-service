package com.mycat.micro.cart.controller;

import com.mycat.micro.cart.model.CartRecord;
import com.mycat.micro.cart.model.Product;
import com.mycat.micro.cart.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{username}")
    public List<CartRecord> getProductsByUsername(@PathVariable String username) {
        return cartService.getProductsByUsername(username);
    }

    @PostMapping("/add")
    public Integer addProductToCart(String username, Product product, Integer count) {
        return cartService.addProductToCart(username, product, count);
    }
}
