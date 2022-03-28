package com.cy.service;

import com.cy.vo.ProductDetailVo;
import com.cy.vo.ResponseVo;
import com.github.pagehelper.PageInfo;

/**
 * @Create by 猪小帅
 * @date 2022/3/28 10:48
 * @mood happy
 */

public interface IProductService {

    ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize);

    ResponseVo<ProductDetailVo> detail(Integer productId);
}
