package com.cy.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Create by 猪小帅
 * @date 2022/4/2 13:40
 * @mood happy
 */
@Data
public class ShippingForm {

    @NotBlank
    private String receiverName;

    @NotBlank
    private String receiverPhone;

    @NotBlank
    private String receiverMobile;

    @NotBlank
    private String receiverProvince;

    @NotBlank
    private String receiverCity;

    @NotBlank
    private String receiverDistrict;

    @NotBlank
    private String receiverAddress;

    @NotBlank
    private String receiverZip;
}
