package com.shucong.mall.mapper;

import com.shucong.mall.bean.Products;
import java.util.List;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ProductsMapper {
    @Insert({
        "insert into products (id,name,thumb,images,description,minPrice,maxPrice,salesCount,warehouseId,status,updatedAt,createdAt)" +
        "values (#{id},#{name},#{thumb},#{images},#{description},#{minPrice},#{maxPrice},#{salesCount},#{warehouseId},#{status},#{updatedAt},#{createdAt})"
    })
    int insert(Products products);

    @Select("SELECT * FROM products WHERE id = #{id}")
    Products findById(String id);

    @Select({
        "select * from products"
    })
    List<Products> findAll();
}