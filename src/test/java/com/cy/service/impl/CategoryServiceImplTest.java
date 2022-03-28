package com.cy.service.impl;

import com.cy.MallApplicationTests;
import com.cy.enums.ResponseEnum;
import com.cy.service.ICategoryService;
import com.cy.vo.CategoryVo;
import com.cy.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Create by 猪小帅
 * @date 2022/3/28 9:31
 * @mood happy
 */
@Slf4j
public class CategoryServiceImplTest extends MallApplicationTests {

    @Autowired
    private ICategoryService categoryService;

    @Test
    public void selectAll() {
        ResponseVo<List<CategoryVo>> responseVo = categoryService.selectAll();
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void findSubCategoryId() {
        Set<Integer> set = new HashSet<>();
        categoryService.findSubCategoryId(100001, set);
        log.info("set = {}", set);
    }
}