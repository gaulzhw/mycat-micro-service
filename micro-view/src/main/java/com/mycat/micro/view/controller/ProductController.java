package com.mycat.micro.view.controller;

import com.mycat.micro.view.model.Product;
import com.mycat.micro.view.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Desc:
 *
 * @date: 27/06/2017
 * @author: gaozhiwen
 */
@Controller
public class ProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping("/product/all")
    public String getProducts(HttpServletRequest request) {
        List<Product> products = productService.getProducts();
        LOGGER.info("products result: {}", products);
        request.setAttribute("products", products);
        return "products";
    }

    @GetMapping("/product/{id}")
    public String getProductById(@PathVariable Integer id, HttpServletRequest request) {
        Product product = productService.getProductById(id);
        LOGGER.info("product for id: {}, result: {}", id, product);
        request.setAttribute("product", product);
        return "product";
    }
}
