package com.mycat.micro.cart.service;

import com.mycat.micro.cart.model.CartRecord;
import com.mycat.micro.cart.model.Result;
import com.mycat.micro.cart.model.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Desc:
 *
 * @date: 27/06/2017
 * @author: gaozhiwen
 */
@Service
public class CartService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CartService.class);
    private static final String REDIS_KEY_PRE_CART = "cart_";

    @Autowired
    private RedisTemplate redisTemplate;

    public List<CartRecord> getProductsByUsername(String username) {
        try {
            List<CartRecord> records = redisTemplate.opsForList().range(REDIS_KEY_PRE_CART + username, 0, -1);
            LOGGER.info("get products by username: {}, result: {}", username, records);
            return records;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public Result addProductToCart(CartRecord cartRecord) {
        try {
            LOGGER.info("add product to cart, cartRecord: {}", cartRecord);
            redisTemplate.opsForList().leftPush(REDIS_KEY_PRE_CART + cartRecord.getUsername(), cartRecord).intValue();
            return new Result(ResultEnum.SUCCESS);
        } catch (Exception e) {
            return new Result(ResultEnum.ERROR);
        }
    }
}
