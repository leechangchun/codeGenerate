package com.test.mapper;

import com.test.model.ProductAttributeValues;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface ProductAttributeValuesMapper {
    @Delete({
        "delete from product_attribute_values",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into product_attribute_values (id, product_id, ",
        "product_attribute_id, value)",
        "values (#{id,jdbcType=INTEGER}, #{productId,jdbcType=INTEGER}, ",
        "#{productAttributeId,jdbcType=INTEGER}, #{value,jdbcType=VARCHAR})"
    })
    int insert(ProductAttributeValues record);

    @Select({
        "select",
        "id, product_id, product_attribute_id, value",
        "from product_attribute_values",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.INTEGER),
        @Result(column="product_attribute_id", property="productAttributeId", jdbcType=JdbcType.INTEGER),
        @Result(column="value", property="value", jdbcType=JdbcType.VARCHAR)
    })
    ProductAttributeValues selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, product_id, product_attribute_id, value",
        "from product_attribute_values"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.INTEGER),
        @Result(column="product_attribute_id", property="productAttributeId", jdbcType=JdbcType.INTEGER),
        @Result(column="value", property="value", jdbcType=JdbcType.VARCHAR)
    })
    List<ProductAttributeValues> selectAll();

    @Update({
        "update product_attribute_values",
        "set product_id = #{productId,jdbcType=INTEGER},",
          "product_attribute_id = #{productAttributeId,jdbcType=INTEGER},",
          "value = #{value,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ProductAttributeValues record);
}