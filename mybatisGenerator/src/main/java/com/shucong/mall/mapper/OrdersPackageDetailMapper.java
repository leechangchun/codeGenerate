package com.shucong.mall.mapper;

import com.shucong.mall.entity.OrdersPackageDetail;
import java.util.List;

public interface OrdersPackageDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrdersPackageDetail record);

    OrdersPackageDetail selectByPrimaryKey(Integer id);

    List<OrdersPackageDetail> selectAll();

    int updateByPrimaryKey(OrdersPackageDetail record);
}