package com.cy.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Create by 猪小帅
 * @date 2022/3/23 14:00
 * @mood happy
 */
@Data
public class UserLoginForm {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
