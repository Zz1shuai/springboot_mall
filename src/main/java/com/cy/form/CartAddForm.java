package com.cy.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 购物车添加商品
 * @Create by 猪小帅
 * @date 2022/3/28 15:29
 * @mood happy
 */
@Data
public class CartAddForm {

    @NotNull
    private Integer productId;

    private Boolean selected = true;
}
