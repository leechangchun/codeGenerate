package com.shucong.mall.mapper;

import com.shucong.mall.entity.ProductAttributeValues;
import java.util.List;

public interface ProductAttributeValuesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductAttributeValues record);

    ProductAttributeValues selectByPrimaryKey(Integer id);

    List<ProductAttributeValues> selectAll();

    int updateByPrimaryKey(ProductAttributeValues record);
}