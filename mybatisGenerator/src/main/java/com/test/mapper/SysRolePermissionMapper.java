package com.test.mapper;

import com.test.model.SysRolePermission;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface SysRolePermissionMapper {
    @Delete({
        "delete from sys_role_permission",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sys_role_permission (id, role_id, ",
        "permission)",
        "values (#{id,jdbcType=INTEGER}, #{roleId,jdbcType=INTEGER}, ",
        "#{permission,jdbcType=VARCHAR})"
    })
    int insert(SysRolePermission record);

    @Select({
        "select",
        "id, role_id, permission",
        "from sys_role_permission",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="permission", property="permission", jdbcType=JdbcType.VARCHAR)
    })
    SysRolePermission selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, role_id, permission",
        "from sys_role_permission"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="permission", property="permission", jdbcType=JdbcType.VARCHAR)
    })
    List<SysRolePermission> selectAll();

    @Update({
        "update sys_role_permission",
        "set role_id = #{roleId,jdbcType=INTEGER},",
          "permission = #{permission,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysRolePermission record);
}