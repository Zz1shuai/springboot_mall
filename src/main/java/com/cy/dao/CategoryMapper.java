package com.cy.dao;

import com.cy.pojo.Category;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


/**
 * 开发生成器: 连接数据库 -> 获取表结构 -> 生成文件
 * @Create by 猪小帅
 * @date 2022/3/22 14:19
 * @mood happy
 */
//@Mapper
public interface CategoryMapper {

    @Select("select * from mall_category where id = #{id}")
    Category findById(@Param("id") Integer id);

    Category queryById(Integer id);
}
