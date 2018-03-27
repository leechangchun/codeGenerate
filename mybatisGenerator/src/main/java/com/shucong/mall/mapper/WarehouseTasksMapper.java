package com.shucong.mall.mapper;

import com.shucong.mall.entity.WarehouseTasks;
import java.util.List;

public interface WarehouseTasksMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WarehouseTasks record);

    WarehouseTasks selectByPrimaryKey(Integer id);

    List<WarehouseTasks> selectAll();

    int updateByPrimaryKey(WarehouseTasks record);
}