package com.test.mapper;

import com.test.model.OrdersPackageDetail;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface OrdersPackageDetailMapper {
    @Delete({
        "delete from orders_package_detail",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into orders_package_detail (id, order_id, ",
        "package_id, product_name, ",
        "product_thumb, product_sku_id, ",
        "product_attribute, quantity, ",
        "price)",
        "values (#{id,jdbcType=INTEGER}, #{orderId,jdbcType=INTEGER}, ",
        "#{packageId,jdbcType=INTEGER}, #{productName,jdbcType=VARCHAR}, ",
        "#{productThumb,jdbcType=VARCHAR}, #{productSkuId,jdbcType=INTEGER}, ",
        "#{productAttribute,jdbcType=VARCHAR}, #{quantity,jdbcType=INTEGER}, ",
        "#{price,jdbcType=DECIMAL})"
    })
    int insert(OrdersPackageDetail record);

    @Select({
        "select",
        "id, order_id, package_id, product_name, product_thumb, product_sku_id, product_attribute, ",
        "quantity, price",
        "from orders_package_detail",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.INTEGER),
        @Result(column="package_id", property="packageId", jdbcType=JdbcType.INTEGER),
        @Result(column="product_name", property="productName", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_thumb", property="productThumb", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_sku_id", property="productSkuId", jdbcType=JdbcType.INTEGER),
        @Result(column="product_attribute", property="productAttribute", jdbcType=JdbcType.VARCHAR),
        @Result(column="quantity", property="quantity", jdbcType=JdbcType.INTEGER),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL)
    })
    OrdersPackageDetail selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, order_id, package_id, product_name, product_thumb, product_sku_id, product_attribute, ",
        "quantity, price",
        "from orders_package_detail"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.INTEGER),
        @Result(column="package_id", property="packageId", jdbcType=JdbcType.INTEGER),
        @Result(column="product_name", property="productName", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_thumb", property="productThumb", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_sku_id", property="productSkuId", jdbcType=JdbcType.INTEGER),
        @Result(column="product_attribute", property="productAttribute", jdbcType=JdbcType.VARCHAR),
        @Result(column="quantity", property="quantity", jdbcType=JdbcType.INTEGER),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL)
    })
    List<OrdersPackageDetail> selectAll();

    @Update({
        "update orders_package_detail",
        "set order_id = #{orderId,jdbcType=INTEGER},",
          "package_id = #{packageId,jdbcType=INTEGER},",
          "product_name = #{productName,jdbcType=VARCHAR},",
          "product_thumb = #{productThumb,jdbcType=VARCHAR},",
          "product_sku_id = #{productSkuId,jdbcType=INTEGER},",
          "product_attribute = #{productAttribute,jdbcType=VARCHAR},",
          "quantity = #{quantity,jdbcType=INTEGER},",
          "price = #{price,jdbcType=DECIMAL}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OrdersPackageDetail record);
}