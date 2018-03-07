package com.test.mapper;

import com.test.model.ProductAttributes;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface ProductAttributesMapper {
    @Delete({
        "delete from product_attributes",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into product_attributes (id, product_id, ",
        "parent_id, name)",
        "values (#{id,jdbcType=INTEGER}, #{productId,jdbcType=INTEGER}, ",
        "#{parentId,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR})"
    })
    int insert(ProductAttributes record);

    @Select({
        "select",
        "id, product_id, parent_id, name",
        "from product_attributes",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.INTEGER),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    ProductAttributes selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, product_id, parent_id, name",
        "from product_attributes"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.INTEGER),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<ProductAttributes> selectAll();

    @Update({
        "update product_attributes",
        "set product_id = #{productId,jdbcType=INTEGER},",
          "parent_id = #{parentId,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ProductAttributes record);
}