package com.shucong.mall.mapper;

import com.shucong.mall.entity.FlashSales;
import java.util.List;

public interface FlashSalesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FlashSales record);

    FlashSales selectByPrimaryKey(Integer id);

    List<FlashSales> selectAll();

    int updateByPrimaryKey(FlashSales record);
}