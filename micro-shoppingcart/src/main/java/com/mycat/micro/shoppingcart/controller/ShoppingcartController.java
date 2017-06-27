package com.mycat.micro.shoppingcart.controller;

import com.mycat.micro.shoppingcart.model.Product;
import com.mycat.micro.shoppingcart.model.ShoppingcartRecord;
import com.mycat.micro.shoppingcart.service.ShoppingcartService;
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
public class ShoppingcartController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingcartController.class);

    @Autowired
    private ShoppingcartService shoppingcartService;

    @GetMapping("/{username}")
    public List<ShoppingcartRecord> getProductsByUsername(@PathVariable String username) {
        return shoppingcartService.getProductsByUsername(username);
    }

    @PostMapping("/add")
    public Integer addProductToCart(String username, Product product, Integer count) {
        return shoppingcartService.addProductToCart(username, product, count);
    }
}
