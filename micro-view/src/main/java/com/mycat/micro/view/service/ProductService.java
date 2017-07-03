package com.mycat.micro.view.service;

import com.mycat.micro.view.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;

/**
 * Desc:
 *
 * @date: 25/06/2017
 * @author: gaozhiwen
 */
@FeignClient(name = "micro-gateway", fallback = ProductService.HystrixProductService.class)
public interface ProductService {
    Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    @GetMapping("/product/all")
    List<Product> getProducts();

    @GetMapping("/product/{id}")
    Product getProductById(@PathVariable("id") Integer id);

    @Component
    class HystrixProductService implements ProductService {
        @Override
        public List<Product> getProducts() {
            LOGGER.warn("hystrix result for products");
            return Collections.EMPTY_LIST;
        }

        @Override
        public Product getProductById(Integer id) {
            LOGGER.warn("hystrix result for product by id: {}", id);
            return null;
        }
    }
}
