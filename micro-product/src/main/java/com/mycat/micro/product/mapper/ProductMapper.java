package com.mycat.micro.product.mapper;

import com.mycat.micro.product.model.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Desc:
 *
 * @date: 27/06/2017
 * @author: gaozhiwen
 */
public interface ProductMapper {
    @Select("select * from product")
    List<Product> getProducts();

    @Select("select * from product where id=#{id,jdbcType=INTEGER}")
    Product getProductById(Integer id);
}
