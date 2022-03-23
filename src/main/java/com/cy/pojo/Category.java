package com.cy.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @Create by 猪小帅
 * @date 2022/3/22 14:02
 * @mood happy
 */
@Data
public class Category {

    private Integer id;

    private Integer parentId;

    private String name;

    private Integer status;

    private Integer sortOrder;

    private Date createTime;

    private Date updateTime;

}
