package com.shucong.mall.mapper;

import com.shucong.mall.entity.Topic;
import java.util.List;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TopicMapper {
    int insert(Topic topic);

    int update(Topic topic);

    Topic findById(int id);

    List<Topic> findAll();

    int deleteById(int id);
}