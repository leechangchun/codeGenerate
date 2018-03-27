package com.shucong.mall.mapper;

import com.shucong.mall.entity.ProductAttributes;
import java.util.List;

public interface ProductAttributesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductAttributes record);

    ProductAttributes selectByPrimaryKey(Integer id);

    List<ProductAttributes> selectAll();

    int updateByPrimaryKey(ProductAttributes record);
}