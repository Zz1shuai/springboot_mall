package com.cy.pojo;

import lombok.Data;

/**
 * @Create by 猪小帅
 * @date 2022/3/29 10:44
 * @mood happy
 */
@Data
public class Cart {

    private Integer productId;

    private Integer quantity;

    private Boolean productSelected;

    public Cart() {
    }

    public Cart(Integer productId, Integer quantity, Boolean productSelected) {
        this.productId = productId;
        this.quantity = quantity;
        this.productSelected = productSelected;
    }
}
