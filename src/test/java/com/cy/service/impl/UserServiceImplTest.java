package com.cy.service.impl;

import com.cy.MallApplicationTests;
import com.cy.enums.RoleEnum;
import com.cy.pojo.User;
import com.cy.service.IUserService;
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

    @Autowired
    private IUserService userService;

    @Test
    public void register() {
       User user = new User("mei", "li", "zhu@qq.com", RoleEnum.CUSTOMER.getCode());
        userService.register(user);
        System.err.println(user);
    }
}