package com.shucong.mall.mapper;

import com.shucong.mall.entity.Orders;
import java.util.List;

public interface OrdersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Orders record);

    Orders selectByPrimaryKey(Integer id);

    List<Orders> selectAll();

    int updateByPrimaryKey(Orders record);
}