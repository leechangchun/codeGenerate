package com.test.mapper;

import com.test.model.Users;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface UsersMapper {
    @Delete({
        "delete from users",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into users (id, unionid, ",
        "openid, nickname, avatar, ",
        "mobile, created_at)",
        "values (#{id,jdbcType=INTEGER}, #{unionid,jdbcType=CHAR}, ",
        "#{openid,jdbcType=CHAR}, #{nickname,jdbcType=VARCHAR}, #{avatar,jdbcType=VARCHAR}, ",
        "#{mobile,jdbcType=CHAR}, #{createdAt,jdbcType=TIMESTAMP})"
    })
    int insert(Users record);

    @Select({
        "select",
        "id, unionid, openid, nickname, avatar, mobile, created_at",
        "from users",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="unionid", property="unionid", jdbcType=JdbcType.CHAR),
        @Result(column="openid", property="openid", jdbcType=JdbcType.CHAR),
        @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.CHAR),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP)
    })
    Users selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, unionid, openid, nickname, avatar, mobile, created_at",
        "from users"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="unionid", property="unionid", jdbcType=JdbcType.CHAR),
        @Result(column="openid", property="openid", jdbcType=JdbcType.CHAR),
        @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.CHAR),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Users> selectAll();

    @Update({
        "update users",
        "set unionid = #{unionid,jdbcType=CHAR},",
          "openid = #{openid,jdbcType=CHAR},",
          "nickname = #{nickname,jdbcType=VARCHAR},",
          "avatar = #{avatar,jdbcType=VARCHAR},",
          "mobile = #{mobile,jdbcType=CHAR},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Users record);
}