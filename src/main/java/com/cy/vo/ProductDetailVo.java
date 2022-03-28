package com.cy.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Create by 猪小帅
 * @date 2022/3/28 14:24
 * @mood happy
 */
@Data
public class ProductDetailVo {

    private Integer id;

    private Integer categoryId;

    private String name;

    private String subtitle;

    private String mainImage;

    private String subImages;

    private String detail;

    private BigDecimal price;

    private Integer stock;

    private Integer status;

    private Date createTime;

    private Date updateTime;
}
