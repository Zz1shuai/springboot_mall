package com.cy.service.impl;

import com.cy.MallApplicationTests;
import com.cy.enums.ResponseEnum;
import com.cy.form.CartAddForm;
import com.cy.service.ICartService;
import com.cy.service.IOrderService;
import com.cy.vo.CartVo;
import com.cy.vo.OrderVo;
import com.cy.vo.ResponseVo;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Create by 猪小帅
 * @date 2022/4/8 16:24
 * @mood happy
 */
@Slf4j
@Transactional
public class OrderServiceImplTest extends MallApplicationTests {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private ICartService cartService;

    private Integer uid = 1;

    private Integer shippingId = 8;

    private Integer productId = 29;

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Before
    public void before() {
        CartAddForm cartAddForm = new CartAddForm();
        cartAddForm.setProductId(productId);
        cartAddForm.setSelected(true);
        ResponseVo<CartVo> add = cartService.add(uid, cartAddForm);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), add.getStatus());
    }

    @Test
    public void creatTest() {
        ResponseVo<OrderVo> responseVo = create();
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
    private ResponseVo<OrderVo> create() {
        ResponseVo<OrderVo> responseVo = orderService.create(uid, shippingId);
        log.info("result={}", gson.toJson(responseVo));
        return responseVo;
    }

    @Test
    public void list() {
        ResponseVo<PageInfo> responseVo = orderService.list(uid, 1,2);
        log.info("result={}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void detail() {
        ResponseVo<OrderVo> vo = create();
        ResponseVo<OrderVo> responseVo = orderService.detail(uid, vo.getData().getOrderNo());
        log.info("result={}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void cancel() {
        ResponseVo<OrderVo> vo = create();
        ResponseVo responseVo = orderService.cancel(uid, vo.getData().getOrderNo());
        log.info("result={}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}