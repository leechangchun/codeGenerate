package com.test.mapper;

import com.test.model.SysRole;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface SysRoleMapper {
    @Delete({
        "delete from sys_role",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sys_role (id, name)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR})"
    })
    int insert(SysRole record);

    @Select({
        "select",
        "id, name",
        "from sys_role",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    SysRole selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, name",
        "from sys_role"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<SysRole> selectAll();

    @Update({
        "update sys_role",
        "set name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysRole record);
}