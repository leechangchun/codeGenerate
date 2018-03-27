package com.shucong.mall.mapper;

import com.shucong.mall.entity.Carts;
import java.util.List;

public interface CartsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Carts record);

    Carts selectByPrimaryKey(Integer id);

    List<Carts> selectAll();

    int updateByPrimaryKey(Carts record);
}