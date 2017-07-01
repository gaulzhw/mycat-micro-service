package com.mycat.micro.view.controller;

import com.mycat.micro.view.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Desc:
 *
 * @date: 01/07/2017
 * @author: gaozhiwen
 */
@RestController
public class CartController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

    @GetMapping("/cart")
    public Result cart(Integer id, int count) {
        return null;
    }
}
