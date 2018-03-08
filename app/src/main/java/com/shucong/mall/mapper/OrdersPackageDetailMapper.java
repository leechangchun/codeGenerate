package com.shucong.mall.mapper;

import com.shucong.mall.bean.OrdersPackageDetail;
import java.util.List;
import org.apache.ibatis.annotations.*;

@Mapper
public interface OrdersPackageDetailMapper {
    @Insert({
        "insert into ordersPackageDetail (id,orderId,packageId,productName,productThumb,productSkuId,productAttribute,quantity,price)" +
        "values (#{id},#{orderId},#{packageId},#{productName},#{productThumb},#{productSkuId},#{productAttribute},#{quantity},#{price})"
    })
    int insert(OrdersPackageDetail ordersPackageDetail);

    @Select("SELECT * FROM ordersPackageDetail WHERE id = #{id}")
    OrdersPackageDetail findById(String id);

    @Select({
        "select * from ordersPackageDetail"
    })
    List<OrdersPackageDetail> findAll();
}