package com.shucong.mall.mapper;

import com.shucong.mall.bean.Admin;
import com.shucong.mall.bean.SysAdminRole;
import com.shucong.mall.bean.SysRolePermission;
import org.apache.ibatis.annotations.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface AdminMapper {

    @Select("SELECT * from sys_admin WHERE username = #{name}")
    Admin findByUsername(@Param("name") String name);

    @Select("SELECT * FROM sys_admin WHERE id = #{id}")
    Admin findById(@Param("id") String id);

    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "username", column = "username"),
    })
    @Select("SELECT * FROM sys_admin")
    List<Admin> findAll();

    @Insert("INSERT INTO sys_admin(username, password) VALUES(#{username}, #{password})")
    int insert(@Param("username") String username, @Param("password") String password);

    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "adminId", column = "admin_id"),
        @Result(property = "roleId", column = "role_id"),
    })
    @Select("SELECT * FROM sys_admin_role WHERE admin_id = #{admin_id}")
    SysAdminRole findAdminRoleById(@Param("admin_id") Long adminId);

    @Select("SELECT * FROM sys_role_permission WHERE role_id = #{role_id}")
    List<SysRolePermission> findRolePermissionByRoleId(@Param("role_id") Long roleId);
}
