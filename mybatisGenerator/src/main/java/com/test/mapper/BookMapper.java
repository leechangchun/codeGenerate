package com.test.mapper;

import com.test.model.Book;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface BookMapper {
    @Delete({
        "delete from book",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into book (id, name)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR})"
    })
    int insert(Book record);

    @Select({
        "select",
        "id, name",
        "from book",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    Book selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, name",
        "from book"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<Book> selectAll();

    @Update({
        "update book",
        "set name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Book record);
}