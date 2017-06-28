package com.mycat.micro.cart.service;

import com.google.common.collect.Lists;
import com.mycat.micro.cart.model.CartRecord;
import com.mycat.micro.cart.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        List<CartRecord> records = Lists.newArrayList();
        redisTemplate.opsForList().leftPushAll(REDIS_KEY_PRE_CART + username, records);
        LOGGER.info("get products by username: {}, result: {}", username, records);
        return records;
    }

    public Integer addProductToCart(String username, Product product, Integer count) {
        CartRecord record = new CartRecord();
        record.setUsername(username);
        record.setProduct(product);
        record.setTime(new Date());
        record.setCount(count);
        LOGGER.info("add product to cart for username: {}, product: {}, count: {}", username, product, count);

        return redisTemplate.opsForList().rightPush(REDIS_KEY_PRE_CART + username, new String(redisTemplate.getHashValueSerializer().serialize(record))).intValue();
    }
}
