package com.mycat.micro.view.service;

import com.mycat.micro.view.model.CartRecord;
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
@FeignClient(name = "micro-gateway", fallback = CartService.HystrixCartService.class)
public interface CartService {
    //    @PostMapping("/cart/add")
//    Integer add(@RequestBody String username, @RequestBody Product product, @RequestBody Integer count);

    @GetMapping("/cart/{username}")
    List<CartRecord> getCartRecords(@PathVariable("username") String username);

    @Component
    class HystrixCartService implements CartService {
//        @Override
//        public Integer add(String username, Product product, Integer count) {
//            return 0;
//        }

        public List<CartRecord> getCartRecords(String username) {
            return Collections.EMPTY_LIST;
        }
    }
}
