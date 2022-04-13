package com.cy.service.impl;

import com.cy.MallApplicationTests;
import com.cy.enums.ResponseEnum;
import com.cy.service.IOrderService;
import com.cy.vo.OrderVo;
import com.cy.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Create by 猪小帅
 * @date 2022/4/8 16:24
 * @mood happy
 */

public class OrderServiceImplTest extends MallApplicationTests {

    @Autowired
    private IOrderService orderService;

    private Integer uid = 1;

    private Integer shippingId = 8;

    @Test
    public void create() {
        ResponseVo<OrderVo> responseVo = orderService.create(uid, shippingId);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}