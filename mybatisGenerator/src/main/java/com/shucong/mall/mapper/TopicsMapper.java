package com.shucong.mall.mapper;

import com.shucong.mall.entity.Topics;
import java.util.List;

public interface TopicsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Topics record);

    Topics selectByPrimaryKey(Integer id);

    List<Topics> selectAll();

    int updateByPrimaryKey(Topics record);
}