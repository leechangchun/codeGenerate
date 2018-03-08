package com.shucong.mall.mapper;

import com.shucong.mall.bean.OrdersPackage;
import java.util.List;
import org.apache.ibatis.annotations.*;

@Mapper
public interface OrdersPackageMapper {
    @Insert({
        "insert into ordersPackage (id,orderId,warehouseId,express,expressNo)" +
        "values (#{id},#{orderId},#{warehouseId},#{express},#{expressNo})"
    })
    int insert(OrdersPackage ordersPackage);

    @Select("SELECT * FROM ordersPackage WHERE id = #{id}")
    OrdersPackage findById(String id);

    @Select({
        "select * from ordersPackage"
    })
    List<OrdersPackage> findAll();
}