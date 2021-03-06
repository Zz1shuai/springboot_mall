package com.cy.enums;

import lombok.Getter;

/**
 * 商品状态.1-在售 2-下架 3-删除
 * @Create by 猪小帅
 * @date 2022/3/28 14:31
 * @mood happy
 */
@Getter
public enum ProductStatusEnum {

    ON_SALE(1, "在售"),

    OFF_SALE(2, "下架"),

    DELETE(3, "删除"),

    ;

    Integer code;
    String desc;

    ProductStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
