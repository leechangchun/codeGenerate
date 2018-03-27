package com.shucong.mall.mapper;

import com.shucong.mall.entity.UsersCoupon;
import java.util.List;

public interface UsersCouponMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UsersCoupon record);

    UsersCoupon selectByPrimaryKey(Integer id);

    List<UsersCoupon> selectAll();

    int updateByPrimaryKey(UsersCoupon record);
}