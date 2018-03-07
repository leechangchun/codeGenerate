package com.test.mapper;

import com.test.model.Orders;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface OrdersMapper {
    @Delete({
        "delete from orders",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into orders (id, order_no, ",
        "user_id, origin_amount, ",
        "amount, receiver_name, ",
        "receiver_mobile, receiver_address, ",
        "status, created_at)",
        "values (#{id,jdbcType=INTEGER}, #{orderNo,jdbcType=CHAR}, ",
        "#{userId,jdbcType=INTEGER}, #{originAmount,jdbcType=DECIMAL}, ",
        "#{amount,jdbcType=DECIMAL}, #{receiverName,jdbcType=VARCHAR}, ",
        "#{receiverMobile,jdbcType=VARCHAR}, #{receiverAddress,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=TINYINT}, #{createdAt,jdbcType=TIMESTAMP})"
    })
    int insert(Orders record);

    @Select({
        "select",
        "id, order_no, user_id, origin_amount, amount, receiver_name, receiver_mobile, ",
        "receiver_address, status, created_at",
        "from orders",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="order_no", property="orderNo", jdbcType=JdbcType.CHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="origin_amount", property="originAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="amount", property="amount", jdbcType=JdbcType.DECIMAL),
        @Result(column="receiver_name", property="receiverName", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiver_mobile", property="receiverMobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiver_address", property="receiverAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP)
    })
    Orders selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, order_no, user_id, origin_amount, amount, receiver_name, receiver_mobile, ",
        "receiver_address, status, created_at",
        "from orders"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="order_no", property="orderNo", jdbcType=JdbcType.CHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="origin_amount", property="originAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="amount", property="amount", jdbcType=JdbcType.DECIMAL),
        @Result(column="receiver_name", property="receiverName", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiver_mobile", property="receiverMobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiver_address", property="receiverAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Orders> selectAll();

    @Update({
        "update orders",
        "set order_no = #{orderNo,jdbcType=CHAR},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "origin_amount = #{originAmount,jdbcType=DECIMAL},",
          "amount = #{amount,jdbcType=DECIMAL},",
          "receiver_name = #{receiverName,jdbcType=VARCHAR},",
          "receiver_mobile = #{receiverMobile,jdbcType=VARCHAR},",
          "receiver_address = #{receiverAddress,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Orders record);
}