package com.shucong.mall.mapper;

import com.shucong.mall.entity.SysRolePermission;
import java.util.List;

public interface SysRolePermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRolePermission record);

    SysRolePermission selectByPrimaryKey(Integer id);

    List<SysRolePermission> selectAll();

    int updateByPrimaryKey(SysRolePermission record);
}