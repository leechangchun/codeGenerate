package com.test.mapper;

import com.test.model.UsersAddress;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface UsersAddressMapper {
    @Delete({
        "delete from users_address",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into users_address (id, user_id, ",
        "name, mobile, province, ",
        "city, district, ",
        "address, is_default)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{name,jdbcType=VARCHAR}, #{mobile,jdbcType=VARCHAR}, #{province,jdbcType=VARCHAR}, ",
        "#{city,jdbcType=VARCHAR}, #{district,jdbcType=VARCHAR}, ",
        "#{address,jdbcType=VARCHAR}, #{isDefault,jdbcType=BIT})"
    })
    int insert(UsersAddress record);

    @Select({
        "select",
        "id, user_id, name, mobile, province, city, district, address, is_default",
        "from users_address",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="district", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_default", property="isDefault", jdbcType=JdbcType.BIT)
    })
    UsersAddress selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, user_id, name, mobile, province, city, district, address, is_default",
        "from users_address"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="district", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_default", property="isDefault", jdbcType=JdbcType.BIT)
    })
    List<UsersAddress> selectAll();

    @Update({
        "update users_address",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "mobile = #{mobile,jdbcType=VARCHAR},",
          "province = #{province,jdbcType=VARCHAR},",
          "city = #{city,jdbcType=VARCHAR},",
          "district = #{district,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "is_default = #{isDefault,jdbcType=BIT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UsersAddress record);
}