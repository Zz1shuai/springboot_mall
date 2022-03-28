package com.cy.controller;

import com.cy.service.ICategoryService;
import com.cy.vo.CategoryVo;
import com.cy.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Create by 猪小帅
 * @date 2022/3/24 14:35
 * @mood happy
 */
@RestController
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/categories")
    public ResponseVo<List<CategoryVo>> selectAll() {
        return categoryService.selectAll();
    }
}
