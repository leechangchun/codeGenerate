package com.shucong.mall.mapper;

import com.shucong.mall.entity.Warehouse;
import java.util.List;

public interface WarehouseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Warehouse record);

    Warehouse selectByPrimaryKey(Integer id);

    List<Warehouse> selectAll();

    int updateByPrimaryKey(Warehouse record);
}