package com.cy.controller;

import com.cy.service.IProductService;
import com.cy.vo.ProductDetailVo;
import com.cy.vo.ResponseVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Create by 猪小帅
 * @date 2022/3/28 13:57
 * @mood happy
 */
@RestController
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/products")
    public ResponseVo<PageInfo> list(@RequestParam(required = false) Integer categoryId,
                                     @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                     @RequestParam(required = false,defaultValue = "10") Integer pageSize) {

        return productService.list(categoryId, pageNum, pageSize);
    }

    @GetMapping("/products/{productId}")
    public ResponseVo<ProductDetailVo> detail(@PathVariable Integer productId) {
        return productService.detail(productId);
    }
}
