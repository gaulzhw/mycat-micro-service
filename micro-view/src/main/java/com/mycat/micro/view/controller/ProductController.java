package com.mycat.micro.view.controller;

import com.google.common.collect.Lists;
import com.mycat.micro.view.model.Product;
import com.mycat.micro.view.service.ProductService;
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
 * @date: 27/06/2017
 * @author: gaozhiwen
 */
@RestController
public class ProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts() {
        List<Product> products = productService.getProducts();
        LOGGER.info("products result: {}", products);
        return products;
    }

    @GetMapping("/products/{id}")
    public List<Product> getProductById(@PathVariable Integer id) {
        Product product = productService.getProductById(id);
        LOGGER.info("product for id: {}, result: {}", id, product);
        return Lists.newArrayList(product);
    }
}
