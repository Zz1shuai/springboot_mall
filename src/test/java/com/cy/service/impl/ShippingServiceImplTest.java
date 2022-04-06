package com.cy.service.impl;

import com.cy.MallApplicationTests;
import com.cy.enums.ResponseEnum;
import com.cy.form.ShippingForm;
import com.cy.service.IShippingService;
import com.cy.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @Create by 猪小帅
 * @date 2022/4/2 14:45
 * @mood happy
 */
@Slf4j
public class ShippingServiceImplTest extends MallApplicationTests {

    @Autowired
    private IShippingService shippingService;

    private Integer uid = 5;

    private Integer shippingId;

    private ShippingForm shippingForm;

    @Before
    public void before() {
        ShippingForm shippingForm = new ShippingForm();
        shippingForm.setReceiverName("赵美丽");
        shippingForm.setReceiverAddress("精金花园");
        shippingForm.setReceiverDistrict("建邺区");
        shippingForm.setReceiverCity("南京市");
        shippingForm.setReceiverProvince("江苏省");
        shippingForm.setReceiverPhone("18351956607");
        shippingForm.setReceiverMobile("010-12345678");
        shippingForm.setReceiverZip("210000");
        this.shippingForm = shippingForm;

        add();
    }


    public void add() {
        ResponseVo<Map<String, Integer>> add = shippingService.add(uid, shippingForm);
        log.info("result = {}", add);
        this.shippingId = add.getData().get("shippingId");
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), add.getStatus());
    }

    @After
    public void delete() {
        ResponseVo delete = shippingService.delete(uid,shippingId);
        log.info("result = {}", delete);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), delete.getStatus());
    }

    @Test
    public void update() {
        shippingForm.setReceiverMobile("13812040092");
        ResponseVo update = shippingService.update(uid, shippingId, shippingForm);
        log.info("result = {}", update);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), update.getStatus());
    }

    @Test
    public void list() {
        ResponseVo list = shippingService.list(uid, 1, 10);
        log.info("result = {}", list);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), list.getStatus());
    }
}