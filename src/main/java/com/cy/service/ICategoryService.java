package com.cy.service;

import com.cy.vo.CategoryVo;
import com.cy.vo.ResponseVo;

import java.util.List;
import java.util.Set;

/**
 * 类目
 * @Create by 猪小帅
 * @date 2022/3/24 14:10
 * @mood happy
 */

public interface ICategoryService {

    ResponseVo<List<CategoryVo>> selectAll();

    void findSubCategoryId(Integer id, Set<Integer> resultSet);
}
