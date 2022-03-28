package com.cy.vo;

import lombok.Data;

import java.util.List;

/**
 * 类目
 * @Create by 猪小帅
 * @date 2022/3/24 13:44
 * @mood happy
 */
@Data
public class CategoryVo {

    private Integer id;

    private Integer parentId;

    private String name;

    private Integer sortOrder;

    private List<CategoryVo> subCategories;
}
