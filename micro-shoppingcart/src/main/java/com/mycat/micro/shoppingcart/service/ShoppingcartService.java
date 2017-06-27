package com.mycat.micro.shoppingcart.service;

import com.google.common.collect.Lists;
import com.mycat.micro.shoppingcart.model.Product;
import com.mycat.micro.shoppingcart.model.ShoppingcartRecord;
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
public class ShoppingcartService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingcartService.class);
    private static final String SHOPPING_KEY_PRE = "shopping_";

    @Autowired
    private RedisTemplate redisTemplate;

    public List<ShoppingcartRecord> getProductsByUsername(String username) {
        List<ShoppingcartRecord> records = Lists.newArrayList();
        redisTemplate.opsForList().leftPushAll(SHOPPING_KEY_PRE + username, records);
        LOGGER.info("get products by username: {}, result: {}", username, records);
        return records;
    }

    public Integer addProductToCart(String username, Product product, Integer count) {
        ShoppingcartRecord record = new ShoppingcartRecord();
        record.setUsername(username);
        record.setProduct(product);
        record.setTime(new Date());
        record.setCount(count);
        LOGGER.info("add product to cart for username: {}, product: {}, count: {}", username, product, count);

        return redisTemplate.opsForList().rightPush(SHOPPING_KEY_PRE + username, new String(redisTemplate.getHashValueSerializer().serialize(record))).intValue();
    }
}
