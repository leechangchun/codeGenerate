package com.shucong.mall.mapper;

import com.shucong.mall.entity.SysAdminRole;
import java.util.List;

public interface SysAdminRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysAdminRole record);

    SysAdminRole selectByPrimaryKey(Integer id);

    List<SysAdminRole> selectAll();

    int updateByPrimaryKey(SysAdminRole record);
}