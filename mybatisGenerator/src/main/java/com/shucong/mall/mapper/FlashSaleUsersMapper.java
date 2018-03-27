package com.shucong.mall.mapper;

import com.shucong.mall.entity.FlashSaleUsers;
import java.util.List;

public interface FlashSaleUsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FlashSaleUsers record);

    FlashSaleUsers selectByPrimaryKey(Integer id);

    List<FlashSaleUsers> selectAll();

    int updateByPrimaryKey(FlashSaleUsers record);
}