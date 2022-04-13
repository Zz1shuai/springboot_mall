package com.cy.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Create by 猪小帅
 * @date 2022/4/8 13:43
 * @mood happy
 */
@Data
public class OrderItemVo {

    private Long orderNo;

    private Integer productId;

    private String productName;

    private String productImage;

    private BigDecimal currentUnitPrice;

    private Integer quantity;

    private BigDecimal totalPrice;

    private Date createTime;
}
