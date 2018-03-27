package com.shucong.mall.mapper;

import com.shucong.mall.entity.OrdersPackage;
import java.util.List;

public interface OrdersPackageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrdersPackage record);

    OrdersPackage selectByPrimaryKey(Integer id);

    List<OrdersPackage> selectAll();

    int updateByPrimaryKey(OrdersPackage record);
}