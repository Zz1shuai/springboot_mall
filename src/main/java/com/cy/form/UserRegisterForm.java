package com.cy.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Create by 猪小帅
 * @date 2022/3/23 14:00
 * @mood happy
 */
@Data
public class UserRegisterForm {

//    @NotBlank 用于String 判断空格
//    @NotEmpty 用于集合
//    @NotNull
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String email;
}
