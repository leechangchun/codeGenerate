package com.shucong.mall.mapper;

import com.shucong.mall.bean.Carts;
import java.util.List;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CartsMapper {
    @Insert({
        "insert into carts (id,userId,skuId,productId,productName,productAttribute,thumb,price,quantity)" +
        "values (#{id},#{userId},#{skuId},#{productId},#{productName},#{productAttribute},#{thumb},#{price},#{quantity})"
    })
    int insert(Carts carts);

    @Select("SELECT * FROM carts WHERE id = #{id}")
    Carts findById(String id);

    @Select({
        "select * from carts"
    })
    List<Carts> findAll();
}