package com.cy.controller;

import com.cy.form.CartAddForm;
import com.cy.vo.CartVo;
import com.cy.vo.ResponseVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Create by 猪小帅
 * @date 2022/3/28 15:32
 * @mood happy
 */
@RestController
public class CartController {

    @PostMapping("/carts")
    public ResponseVo<CartVo> add(@Valid @RequestBody CartAddForm cartAddForm) {
        return null;
    }

}
