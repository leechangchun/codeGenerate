package com.shucong.mall.mapper;

import com.shucong.mall.entity.TopicProducts;
import java.util.List;

public interface TopicProductsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TopicProducts record);

    TopicProducts selectByPrimaryKey(Integer id);

    List<TopicProducts> selectAll();

    int updateByPrimaryKey(TopicProducts record);
}