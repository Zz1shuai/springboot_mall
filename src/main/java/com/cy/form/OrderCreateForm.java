package com.cy.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Create by 猪小帅
 * @date 2022/4/29 13:23
 * @mood happy
 */
@Data
public class OrderCreateForm {
    @NotNull
    private Integer shippingId;
}
