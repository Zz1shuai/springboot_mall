package com.cy.service.impl;

import com.cy.MallApplicationTests;
import com.cy.enums.ResponseEnum;
import com.cy.service.IProductService;
import com.cy.vo.ProductDetailVo;
import com.cy.vo.ResponseVo;
import com.github.pagehelper.PageInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Create by 猪小帅
 * @date 2022/3/28 11:25
 * @mood happy
 */

public class ProductServiceImplTest extends MallApplicationTests {

    @Autowired
    private IProductService productService;

    @Test
    public void list() {
        ResponseVo<PageInfo> responseVo = productService.list(null, 2, 3);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void detail() {
        ResponseVo<ProductDetailVo> responseVo = productService.detail(26);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}