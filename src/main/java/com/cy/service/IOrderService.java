package com.cy.service;

import com.cy.vo.OrderVo;
import com.cy.vo.ResponseVo;

/**
 * @Create by 猪小帅
 * @date 2022/4/8 13:52
 * @mood happy
 */

public interface IOrderService {

    ResponseVo<OrderVo> create(Integer uid, Integer shippingId);
}
