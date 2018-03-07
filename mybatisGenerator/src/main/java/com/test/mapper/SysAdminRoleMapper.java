package com.test.mapper;

import com.test.model.SysAdminRole;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface SysAdminRoleMapper {
    @Delete({
        "delete from sys_admin_role",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sys_admin_role (id, admin_id, ",
        "role_id)",
        "values (#{id,jdbcType=INTEGER}, #{adminId,jdbcType=INTEGER}, ",
        "#{roleId,jdbcType=INTEGER})"
    })
    int insert(SysAdminRole record);

    @Select({
        "select",
        "id, admin_id, role_id",
        "from sys_admin_role",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="admin_id", property="adminId", jdbcType=JdbcType.INTEGER),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER)
    })
    SysAdminRole selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, admin_id, role_id",
        "from sys_admin_role"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="admin_id", property="adminId", jdbcType=JdbcType.INTEGER),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER)
    })
    List<SysAdminRole> selectAll();

    @Update({
        "update sys_admin_role",
        "set admin_id = #{adminId,jdbcType=INTEGER},",
          "role_id = #{roleId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysAdminRole record);
}