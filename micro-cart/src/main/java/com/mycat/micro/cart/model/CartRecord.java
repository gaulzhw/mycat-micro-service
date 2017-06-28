package com.mycat.micro.cart.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Desc:
 *
 * @date: 27/06/2017
 * @author: gaozhiwen
 */
public class CartRecord implements Serializable {
    private static final long serialVersionUID = -5715176690101633737L;
    private Product product;
    private String username;
    private Date time;
    private Integer count;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CartRecord{" +
                "product=" + product +
                ", username='" + username + '\'' +
                ", time=" + time +
                ", count=" + count +
                '}';
    }
}
