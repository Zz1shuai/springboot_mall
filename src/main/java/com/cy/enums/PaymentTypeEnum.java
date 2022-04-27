package com.cy.enums;

import lombok.Getter;

/**
 * @Create by 猪小帅
 * @date 2022/4/14 13:51
 * @mood happy
 */
@Getter
public enum PaymentTypeEnum {

    PAYMENT_ONLINE(1, "在线支付"),
    ;

    Integer code;
    String desc;

    PaymentTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
