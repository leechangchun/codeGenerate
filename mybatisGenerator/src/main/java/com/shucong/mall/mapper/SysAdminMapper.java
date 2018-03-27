package com.shucong.mall.mapper;

import com.shucong.mall.entity.SysAdmin;
import java.util.List;

public interface SysAdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysAdmin record);

    SysAdmin selectByPrimaryKey(Integer id);

    List<SysAdmin> selectAll();

    int updateByPrimaryKey(SysAdmin record);
}