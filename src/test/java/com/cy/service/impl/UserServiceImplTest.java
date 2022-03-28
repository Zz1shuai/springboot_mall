package com.cy.service.impl;

import com.cy.MallApplicationTests;
import com.cy.enums.ResponseEnum;
import com.cy.enums.RoleEnum;
import com.cy.pojo.User;
import com.cy.service.IUserService;
import com.cy.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Create by 猪小帅
 * @date 2022/3/23 10:45
 * @mood happy
 */
@Transactional
public class UserServiceImplTest extends MallApplicationTests {

    public static final String USERNAME = "mei";
    public static final String PASSWORD = "li";

    @Autowired
    private IUserService userService;

    @Before
    public void register() {
       User user = new User(USERNAME, PASSWORD, "zhu@qq.com", RoleEnum.CUSTOMER.getCode());
        userService.register(user);
        System.err.println(user);
    }

    @Test
    public void login() {

        ResponseVo<User> responseVo = userService.login(USERNAME, PASSWORD);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}