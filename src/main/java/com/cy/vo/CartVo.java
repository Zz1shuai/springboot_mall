package com.cy.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 购物车
 * @Create by 猪小帅
 * @date 2022/3/28 14:57
 * @mood happy
 */
@Data
public class CartVo {

    private List<CartProductVo> cartProductVoList;

    private Boolean selectedAll;

    private BigDecimal cartTotalPrice;

    private Integer cartTotalQuantity;
}
