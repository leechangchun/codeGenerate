package com.shucong.mall.mapper;

import com.shucong.mall.bean.ProductAttributeValues;
import java.util.List;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ProductAttributeValuesMapper {
    @Insert({
        "insert into productAttributeValues (id,productId,productAttributeId,value)" +
        "values (#{id},#{productId},#{productAttributeId},#{value})"
    })
    int insert(ProductAttributeValues productAttributeValues);

    @Select("SELECT * FROM productAttributeValues WHERE id = #{id}")
    ProductAttributeValues findById(String id);

    @Select({
        "select * from productAttributeValues"
    })
    List<ProductAttributeValues> findAll();
}