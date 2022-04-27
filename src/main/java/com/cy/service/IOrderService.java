package com.cy.service;

import com.cy.vo.OrderVo;
import com.cy.vo.ResponseVo;
import com.github.pagehelper.PageInfo;

/**
 * @Create by 猪小帅
 * @date 2022/4/8 13:52
 * @mood happy
 */

public interface IOrderService {

    ResponseVo<OrderVo> create(Integer uid, Integer shippingId);

    ResponseVo<PageInfo> list(Integer uid, Integer pageNum, Integer pageSize);

    ResponseVo<OrderVo> detail(Integer uid, Long orderNo);
}
