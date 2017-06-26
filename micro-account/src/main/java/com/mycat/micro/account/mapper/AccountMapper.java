package com.mycat.micro.account.mapper;

import com.mycat.micro.account.model.Account;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Desc:
 *
 * @date: 25/06/2017
 * @author: gaozhiwen
 */
public interface AccountMapper {
    @Select("select * from account where name=#{name,jdbcType=VARCHAR} and password=#{password,jdbcType=VARCHAR}")
    Account getAccountByNameAndPwd(@Param("name") String name, @Param("password") String password);
}
