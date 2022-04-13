package com.cy.vo;

import com.cy.pojo.Shipping;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Create by 猪小帅
 * @date 2022/4/8 13:34
 * @mood happy
 */
@Data
public class OrderVo {

    private Long orderNo;

    private BigDecimal payment;

    private Integer paymentType;

    private Integer postage;

    private Integer status;

    private Date paymentTime;

    private Date sendTime;

    private Date endTime;

    private Date closeTime;

    private Date createTime;

    private List<OrderItemVo> OrderItemVoList;

    private Integer shippingId;

    private Shipping shippingVo;
}
