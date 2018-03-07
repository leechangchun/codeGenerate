package com.test.mapper;

import com.test.model.ProductSku;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface ProductSkuMapper {
    @Delete({
        "delete from product_sku",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into product_sku (id, product_id, ",
        "name, product_attribute, ",
        "price, quantity, ",
        "image, sales_count)",
        "values (#{id,jdbcType=INTEGER}, #{productId,jdbcType=INTEGER}, ",
        "#{name,jdbcType=VARCHAR}, #{productAttribute,jdbcType=VARCHAR}, ",
        "#{price,jdbcType=DECIMAL}, #{quantity,jdbcType=INTEGER}, ",
        "#{image,jdbcType=VARCHAR}, #{salesCount,jdbcType=INTEGER})"
    })
    int insert(ProductSku record);

    @Select({
        "select",
        "id, product_id, name, product_attribute, price, quantity, image, sales_count",
        "from product_sku",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_attribute", property="productAttribute", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="quantity", property="quantity", jdbcType=JdbcType.INTEGER),
        @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR),
        @Result(column="sales_count", property="salesCount", jdbcType=JdbcType.INTEGER)
    })
    ProductSku selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, product_id, name, product_attribute, price, quantity, image, sales_count",
        "from product_sku"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_attribute", property="productAttribute", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="quantity", property="quantity", jdbcType=JdbcType.INTEGER),
        @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR),
        @Result(column="sales_count", property="salesCount", jdbcType=JdbcType.INTEGER)
    })
    List<ProductSku> selectAll();

    @Update({
        "update product_sku",
        "set product_id = #{productId,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "product_attribute = #{productAttribute,jdbcType=VARCHAR},",
          "price = #{price,jdbcType=DECIMAL},",
          "quantity = #{quantity,jdbcType=INTEGER},",
          "image = #{image,jdbcType=VARCHAR},",
          "sales_count = #{salesCount,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ProductSku record);
}