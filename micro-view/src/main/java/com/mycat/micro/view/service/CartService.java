package com.mycat.micro.view.service;

import com.mycat.micro.view.model.CartRecord;
import com.mycat.micro.view.model.Result;
import com.mycat.micro.view.model.ResultEnum;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

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
    @PostMapping("/cart/records")
    Result add(@RequestBody CartRecord cartRecord, @RequestHeader("Cookie") String sessionId);

    @GetMapping("/cart/records")
    List<CartRecord> getCartRecords(@RequestHeader("Cookie") String sessionId);

    @Component
    class HystrixCartService implements CartService {
        @Override
        public Result add(CartRecord cartRecord, String sessionId) {
            return new Result(ResultEnum.ERROR);
        }

        public List<CartRecord> getCartRecords(String sessionId) {
            return Collections.EMPTY_LIST;
        }
    }
}
