package com.cy.enums;

import lombok.Getter;

/**
 * 角色0-管理员,1-普通用户
 * @Create by 猪小帅
 * @date 2022/3/23 10:53
 * @mood happy
 */
@Getter
public enum RoleEnum {
    ADMIN(0, "管理员"),

    CUSTOMER(1, "普通用户"),

    ;

    Integer code;
    String desc;

    RoleEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
