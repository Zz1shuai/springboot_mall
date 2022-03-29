package com.cy.service.impl;

import com.cy.MallApplicationTests;
import com.cy.enums.ResponseEnum;
import com.cy.form.CartAddForm;
import com.cy.form.CartUpdateForm;
import com.cy.service.ICartService;
import com.cy.vo.CartVo;
import com.cy.vo.ResponseVo;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Create by 猪小帅
 * @date 2022/3/29 10:56
 * @mood happy
 */
@Slf4j
public class CartServiceImplTest extends MallApplicationTests {

    @Autowired
    private ICartService cartService;

    private Gson gson = new Gson().newBuilder().setPrettyPrinting().create();

    private Integer uid = 1;

    private Integer productId = 29;

    @Before
    public void add() {
        log.info("【新增购物车......】");
        CartAddForm cartAddForm = new CartAddForm();
        cartAddForm.setProductId(productId);
        cartAddForm.setSelected(true);
        ResponseVo<CartVo> add = cartService.add(uid, cartAddForm);
        log.info("result = {}", gson.toJson(add));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), add.getStatus());
    }

    @Test
    public void list() {
        ResponseVo<CartVo> list = cartService.list(uid);
        log.info("list = {}", gson.toJson(list));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), list.getStatus());
    }

    @Test
    public void update() {
        CartUpdateForm cartUpdateForm = new CartUpdateForm();
        cartUpdateForm.setQuantity(5);
        cartUpdateForm.setSelected(false);
        ResponseVo<CartVo> update = cartService.update(uid, productId, cartUpdateForm);
        log.info("result = {}", gson.toJson(update));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), update.getStatus());
    }

    @After
    public void delete() {
        log.info("【删除购物车......】");
        ResponseVo<CartVo> delete = cartService.delete(uid, productId);
        log.info("result = {}", gson.toJson(delete));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), delete.getStatus());
    }

    @Test
    public void selectAll() {
        ResponseVo<CartVo> selectAll = cartService.selectAll(uid);
        log.info("result = {}", gson.toJson(selectAll));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), selectAll.getStatus());
    }

    @Test
    public void unSelectAll() {
        ResponseVo<CartVo> unSelectAll = cartService.unSelectAll(uid);
        log.info("result = {}", gson.toJson(unSelectAll));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), unSelectAll.getStatus());
    }

    @Test
    public void sum() {
        ResponseVo<Integer> sum = cartService.sum(uid);
        log.info("result = {}", gson.toJson(sum));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), sum.getStatus());
    }

}