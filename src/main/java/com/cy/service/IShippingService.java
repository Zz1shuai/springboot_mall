package com.cy.service;

import com.cy.form.ShippingForm;
import com.cy.vo.ResponseVo;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * @Create by 猪小帅
 * @date 2022/4/2 13:48
 * @mood happy
 */

public interface IShippingService {

    ResponseVo<Map<String, Integer>> add(Integer uid, ShippingForm shippingForm);

    ResponseVo delete(Integer uid, Integer shippingId);

    ResponseVo update(Integer uid, Integer shippingId, ShippingForm shippingForm);

    ResponseVo<PageInfo> list(Integer uid, Integer pageNum, Integer pageSize);
}
