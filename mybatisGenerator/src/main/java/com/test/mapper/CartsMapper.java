package com.test.mapper;

import com.test.model.Carts;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface CartsMapper {
    @Delete({
        "delete from carts",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into carts (id, user_id, ",
        "sku_id, product_id, ",
        "product_name, product_attribute, ",
        "thumb, price, quantity)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{skuId,jdbcType=INTEGER}, #{productId,jdbcType=INTEGER}, ",
        "#{productName,jdbcType=VARCHAR}, #{productAttribute,jdbcType=VARCHAR}, ",
        "#{thumb,jdbcType=VARCHAR}, #{price,jdbcType=DECIMAL}, #{quantity,jdbcType=INTEGER})"
    })
    int insert(Carts record);

    @Select({
        "select",
        "id, user_id, sku_id, product_id, product_name, product_attribute, thumb, price, ",
        "quantity",
        "from carts",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="sku_id", property="skuId", jdbcType=JdbcType.INTEGER),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.INTEGER),
        @Result(column="product_name", property="productName", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_attribute", property="productAttribute", jdbcType=JdbcType.VARCHAR),
        @Result(column="thumb", property="thumb", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="quantity", property="quantity", jdbcType=JdbcType.INTEGER)
    })
    Carts selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, user_id, sku_id, product_id, product_name, product_attribute, thumb, price, ",
        "quantity",
        "from carts"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="sku_id", property="skuId", jdbcType=JdbcType.INTEGER),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.INTEGER),
        @Result(column="product_name", property="productName", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_attribute", property="productAttribute", jdbcType=JdbcType.VARCHAR),
        @Result(column="thumb", property="thumb", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="quantity", property="quantity", jdbcType=JdbcType.INTEGER)
    })
    List<Carts> selectAll();

    @Update({
        "update carts",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "sku_id = #{skuId,jdbcType=INTEGER},",
          "product_id = #{productId,jdbcType=INTEGER},",
          "product_name = #{productName,jdbcType=VARCHAR},",
          "product_attribute = #{productAttribute,jdbcType=VARCHAR},",
          "thumb = #{thumb,jdbcType=VARCHAR},",
          "price = #{price,jdbcType=DECIMAL},",
          "quantity = #{quantity,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Carts record);
}