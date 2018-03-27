package com.shucong.mall.mapper;

import com.shucong.mall.entity.ProductSku;
import java.util.List;

public interface ProductSkuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductSku record);

    ProductSku selectByPrimaryKey(Integer id);

    List<ProductSku> selectAll();

    int updateByPrimaryKey(ProductSku record);
}