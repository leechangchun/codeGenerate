package com.test.mapper;

import com.test.model.Warehouse;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface WarehouseMapper {
    @Delete({
        "delete from warehouse",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into warehouse (id, name, ",
        "province, city, ",
        "district, address)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{province,jdbcType=VARCHAR}, #{city,jdbcType=VARCHAR}, ",
        "#{district,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR})"
    })
    int insert(Warehouse record);

    @Select({
        "select",
        "id, name, province, city, district, address",
        "from warehouse",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="district", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR)
    })
    Warehouse selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, name, province, city, district, address",
        "from warehouse"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="district", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR)
    })
    List<Warehouse> selectAll();

    @Update({
        "update warehouse",
        "set name = #{name,jdbcType=VARCHAR},",
          "province = #{province,jdbcType=VARCHAR},",
          "city = #{city,jdbcType=VARCHAR},",
          "district = #{district,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Warehouse record);
}