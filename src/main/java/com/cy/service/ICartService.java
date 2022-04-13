package com.cy.service;

import com.cy.form.CartAddForm;
import com.cy.form.CartUpdateForm;
import com.cy.pojo.Cart;
import com.cy.vo.CartVo;
import com.cy.vo.ResponseVo;

import java.util.List;

/**
 * @Create by 猪小帅
 * @date 2022/3/29 9:56
 * @mood happy
 */

public interface ICartService {

    ResponseVo<CartVo> add(Integer uid, CartAddForm cartAddForm);

    ResponseVo<CartVo> list(Integer uid);

    ResponseVo<CartVo> update(Integer uid, Integer productId, CartUpdateForm cartUpdateForm);

    ResponseVo<CartVo> delete(Integer uid, Integer productId);

    ResponseVo<CartVo> selectAll(Integer uid);

    ResponseVo<CartVo> unSelectAll(Integer uid);

    ResponseVo<Integer> sum(Integer uid);

    List<Cart> listForCart(Integer uid);
}
