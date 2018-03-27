package com.shucong.mall.mapper;

import com.shucong.mall.entity.ProductImages;
import java.util.List;

public interface ProductImagesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductImages record);

    ProductImages selectByPrimaryKey(Integer id);

    List<ProductImages> selectAll();

    int updateByPrimaryKey(ProductImages record);
}