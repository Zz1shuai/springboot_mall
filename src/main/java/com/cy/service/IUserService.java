package com.cy.service;

import com.cy.pojo.User;
import com.cy.vo.ResponseVo;

/**
 * @Create by 猪小帅
 * @date 2022/3/23 10:15
 * @mood happy
 */

public interface IUserService {

    /**
     * 注册
     */
    ResponseVo<User> register(User user);

    /**
     * 登录
     */
    ResponseVo<User> login(String username, String password);
}
