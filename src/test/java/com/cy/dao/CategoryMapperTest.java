package com.cy.dao;

import com.cy.MallApplicationTests;
import com.cy.pojo.Category;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @Create by 猪小帅
 * @date 2022/3/22 16:01
 * @mood happy
 */

public class CategoryMapperTest extends MallApplicationTests {

    @Autowired
    private CategoryMapper categoryMapper;
    @Test
    public void findById() {
        Category category = categoryMapper.findById(100001);
        System.err.println(category.toString());
    }

    @Test
    public void queryById() {
        Category category = categoryMapper.queryById(100001);
        System.err.println(category.toString());
    }
}