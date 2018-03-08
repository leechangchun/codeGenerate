package com.shucong.mall.mapper;

import com.shucong.mall.bean.ProductSku;
import java.util.List;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ProductSkuMapper {
    @Insert({
        "insert into productSku (id,productId,name,productAttribute,price,quantity,image,salesCount)" +
        "values (#{id},#{productId},#{name},#{productAttribute},#{price},#{quantity},#{image},#{salesCount})"
    })
    int insert(ProductSku productSku);

    @Select("SELECT * FROM productSku WHERE id = #{id}")
    ProductSku findById(String id);

    @Select({
        "select * from productSku"
    })
    List<ProductSku> findAll();
}