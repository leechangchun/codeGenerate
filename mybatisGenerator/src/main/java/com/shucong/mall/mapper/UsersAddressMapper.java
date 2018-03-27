package com.shucong.mall.mapper;

import com.shucong.mall.entity.UsersAddress;
import java.util.List;

public interface UsersAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UsersAddress record);

    UsersAddress selectByPrimaryKey(Integer id);

    List<UsersAddress> selectAll();

    int updateByPrimaryKey(UsersAddress record);
}