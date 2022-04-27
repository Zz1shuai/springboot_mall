package com.cy.dao;

import com.cy.pojo.Shipping;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface ShippingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shipping record);

    int deleteByIdAndUid(@Param("uid") Integer uid,
                         @Param("shippingId") Integer shippingId);

    Shipping selectByUidAndShippingId(@Param("uid") Integer uid,
                                      @Param("shippingId") Integer shippingId);

    int insertSelective(Shipping record);

    Shipping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shipping record);

    int updateByPrimaryKey(Shipping record);

    List<Shipping> selectByUid(Integer uid);

    List<Shipping> selectByIdSet(@Param("idSet") Set idSet);
}