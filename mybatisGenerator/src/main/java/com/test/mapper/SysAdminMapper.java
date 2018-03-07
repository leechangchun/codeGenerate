package com.test.mapper;

import com.test.model.SysAdmin;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface SysAdminMapper {
    @Delete({
        "delete from sys_admin",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sys_admin (id, username, ",
        "password)",
        "values (#{id,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=CHAR})"
    })
    int insert(SysAdmin record);

    @Select({
        "select",
        "id, username, password",
        "from sys_admin",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.CHAR)
    })
    SysAdmin selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, username, password",
        "from sys_admin"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.CHAR)
    })
    List<SysAdmin> selectAll();

    @Update({
        "update sys_admin",
        "set username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=CHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysAdmin record);
}