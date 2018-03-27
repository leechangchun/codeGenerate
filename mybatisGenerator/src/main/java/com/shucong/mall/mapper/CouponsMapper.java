package com.shucong.mall.mapper;

import com.shucong.mall.entity.Coupons;
import java.util.List;

public interface CouponsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Coupons record);

    Coupons selectByPrimaryKey(Integer id);

    List<Coupons> selectAll();

    int updateByPrimaryKey(Coupons record);
}