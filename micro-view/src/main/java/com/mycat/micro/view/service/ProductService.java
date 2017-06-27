package com.mycat.micro.view.service;

import com.mycat.micro.view.model.Product;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Desc:
 *
 * @date: 25/06/2017
 * @author: gaozhiwen
 */
@FeignClient(name = "micro-gateway", fallback = ProductService.HystrixAccountService.class)
public interface ProductService {
    @GetMapping("/product/all")
    List<Product> getProducts();

    @GetMapping("/product/{id}")
    Product getProductById(@PathVariable("id") Integer id);

    @Component
    class HystrixAccountService implements ProductService {
        @Override
        public List<Product> getProducts() {
            return null;
        }

        @Override
        public Product getProductById(Integer id) {
            return null;
        }
    }
}
