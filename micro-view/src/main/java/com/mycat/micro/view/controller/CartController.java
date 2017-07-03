package com.mycat.micro.view.controller;

import com.mycat.micro.view.model.CartRecord;
import com.mycat.micro.view.model.Result;
import com.mycat.micro.view.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/cart/{id}/{count}")
    public Result cart(@PathVariable Integer id, @PathVariable Integer count) {
        return null;
    }

    @GetMapping("/cart/record")
    public List<CartRecord> getCartRecords(@PathVariable String username) {
        return cartService.getCartRecords(username);
    }
}
