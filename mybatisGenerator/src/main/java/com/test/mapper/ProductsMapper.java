package com.test.mapper;

import com.test.model.Products;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface ProductsMapper {
    @Delete({
        "delete from products",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into products (id, name, ",
        "thumb, images, min_price, ",
        "max_price, sales_count, ",
        "warehouse_id, status, ",
        "updated_at, created_at, ",
        "description)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{thumb,jdbcType=VARCHAR}, #{images,jdbcType=VARCHAR}, #{minPrice,jdbcType=DECIMAL}, ",
        "#{maxPrice,jdbcType=DECIMAL}, #{salesCount,jdbcType=INTEGER}, ",
        "#{warehouseId,jdbcType=INTEGER}, #{status,jdbcType=BIT}, ",
        "#{updatedAt,jdbcType=TIMESTAMP}, #{createdAt,jdbcType=TIMESTAMP}, ",
        "#{description,jdbcType=LONGVARCHAR})"
    })
    int insert(Products record);

    @Select({
        "select",
        "id, name, thumb, images, min_price, max_price, sales_count, warehouse_id, status, ",
        "updated_at, created_at, description",
        "from products",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="thumb", property="thumb", jdbcType=JdbcType.VARCHAR),
        @Result(column="images", property="images", jdbcType=JdbcType.VARCHAR),
        @Result(column="min_price", property="minPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="max_price", property="maxPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="sales_count", property="salesCount", jdbcType=JdbcType.INTEGER),
        @Result(column="warehouse_id", property="warehouseId", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="description", property="description", jdbcType=JdbcType.LONGVARCHAR)
    })
    Products selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, name, thumb, images, min_price, max_price, sales_count, warehouse_id, status, ",
        "updated_at, created_at, description",
        "from products"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="thumb", property="thumb", jdbcType=JdbcType.VARCHAR),
        @Result(column="images", property="images", jdbcType=JdbcType.VARCHAR),
        @Result(column="min_price", property="minPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="max_price", property="maxPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="sales_count", property="salesCount", jdbcType=JdbcType.INTEGER),
        @Result(column="warehouse_id", property="warehouseId", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="description", property="description", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Products> selectAll();

    @Update({
        "update products",
        "set name = #{name,jdbcType=VARCHAR},",
          "thumb = #{thumb,jdbcType=VARCHAR},",
          "images = #{images,jdbcType=VARCHAR},",
          "min_price = #{minPrice,jdbcType=DECIMAL},",
          "max_price = #{maxPrice,jdbcType=DECIMAL},",
          "sales_count = #{salesCount,jdbcType=INTEGER},",
          "warehouse_id = #{warehouseId,jdbcType=INTEGER},",
          "status = #{status,jdbcType=BIT},",
          "updated_at = #{updatedAt,jdbcType=TIMESTAMP},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP},",
          "description = #{description,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Products record);
}