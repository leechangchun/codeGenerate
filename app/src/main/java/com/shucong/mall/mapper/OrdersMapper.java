package com.shucong.mall.mapper;

import com.shucong.mall.bean.Orders;
import java.util.List;
import org.apache.ibatis.annotations.*;

@Mapper
public interface OrdersMapper {
    @Insert({
        "insert into orders (id,orderNo,userId,originAmount,amount,receiverName,receiverMobile,receiverAddress,status,createdAt)" +
        "values (#{id},#{orderNo},#{userId},#{originAmount},#{amount},#{receiverName},#{receiverMobile},#{receiverAddress},#{status},#{createdAt})"
    })
    int insert(Orders orders);

    @Select("SELECT * FROM orders WHERE id = #{id}")
    Orders findById(String id);

    @Select({
        "select * from orders"
    })
    List<Orders> findAll();
}