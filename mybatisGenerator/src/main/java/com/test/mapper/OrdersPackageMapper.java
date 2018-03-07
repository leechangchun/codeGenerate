package com.test.mapper;

import com.test.model.OrdersPackage;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface OrdersPackageMapper {
    @Delete({
        "delete from orders_package",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into orders_package (id, order_id, ",
        "warehouse_id, express, ",
        "express_no)",
        "values (#{id,jdbcType=INTEGER}, #{orderId,jdbcType=INTEGER}, ",
        "#{warehouseId,jdbcType=INTEGER}, #{express,jdbcType=VARCHAR}, ",
        "#{expressNo,jdbcType=VARCHAR})"
    })
    int insert(OrdersPackage record);

    @Select({
        "select",
        "id, order_id, warehouse_id, express, express_no",
        "from orders_package",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.INTEGER),
        @Result(column="warehouse_id", property="warehouseId", jdbcType=JdbcType.INTEGER),
        @Result(column="express", property="express", jdbcType=JdbcType.VARCHAR),
        @Result(column="express_no", property="expressNo", jdbcType=JdbcType.VARCHAR)
    })
    OrdersPackage selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, order_id, warehouse_id, express, express_no",
        "from orders_package"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.INTEGER),
        @Result(column="warehouse_id", property="warehouseId", jdbcType=JdbcType.INTEGER),
        @Result(column="express", property="express", jdbcType=JdbcType.VARCHAR),
        @Result(column="express_no", property="expressNo", jdbcType=JdbcType.VARCHAR)
    })
    List<OrdersPackage> selectAll();

    @Update({
        "update orders_package",
        "set order_id = #{orderId,jdbcType=INTEGER},",
          "warehouse_id = #{warehouseId,jdbcType=INTEGER},",
          "express = #{express,jdbcType=VARCHAR},",
          "express_no = #{expressNo,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OrdersPackage record);
}