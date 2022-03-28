package com.cy.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品列表
 * @Create by 猪小帅
 * @date 2022/3/28 10:03
 * @mood happy
 */
@Data
public class ProductVo {

    private Integer id;

    private Integer categoryId;

    private String name;

    private String subtitle;

    private String mainImage;

    private String subImages;

    private BigDecimal price;

    private Integer status;
}
