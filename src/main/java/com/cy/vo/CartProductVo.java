package com.cy.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Create by 猪小帅
 * @date 2022/3/28 15:07
 * @mood happy
 */
@Data
public class CartProductVo {

    private Integer productId;

    /**
     * 购买的数量
     */
    private Integer quantity;

    private String productName;

    private String productSubtitle;

    private String productMainImage;

    private BigDecimal productPrice;

    private Integer productStatus;

    /**
     * 等于 quantity * productPrice
     */
    private BigDecimal productTotalPrice;

    private Integer productStock;

    /**
     * 商品是否选中
      */
    private Boolean productSelected;

}
