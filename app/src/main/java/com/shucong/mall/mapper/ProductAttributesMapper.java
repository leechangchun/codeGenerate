package com.shucong.mall.mapper;

import com.shucong.mall.bean.ProductAttributes;
import java.util.List;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ProductAttributesMapper {
    @Insert({
        "insert into productAttributes (id,productId,parentId,name)" +
        "values (#{id},#{productId},#{parentId},#{name})"
    })
    int insert(ProductAttributes productAttributes);

    @Select("SELECT * FROM productAttributes WHERE id = #{id}")
    ProductAttributes findById(String id);

    @Select({
        "select * from productAttributes"
    })
    List<ProductAttributes> findAll();
}