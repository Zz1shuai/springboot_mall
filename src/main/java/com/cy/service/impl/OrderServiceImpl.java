package com.cy.service.impl;

import com.cy.dao.ProductMapper;
import com.cy.dao.ShippingMapper;
import com.cy.enums.ProductStatusEnum;
import com.cy.enums.ResponseEnum;
import com.cy.pojo.Cart;
import com.cy.pojo.Product;
import com.cy.pojo.Shipping;
import com.cy.service.ICartService;
import com.cy.service.IOrderService;
import com.cy.vo.OrderVo;
import com.cy.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Create by 猪小帅
 * @date 2022/4/8 13:54
 * @mood happy
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private ShippingMapper shippingMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ICartService cartService;
    @Override
    public ResponseVo<OrderVo> create(Integer uid, Integer shippingId) {
        //收货地址校验（总之是要查出来的）
        Shipping shipping = shippingMapper.selectByUidAndShippingId(uid, shippingId);
        if (shipping ==null) {
            return ResponseVo.error(ResponseEnum.SHIPPING_NOT_EXIST);
        }

        //获取购物车，校验（是否有商品，库存）
        List<Cart> cartList = cartService.listForCart(uid).stream()
                .filter(Cart::getProductSelected)
                .collect(Collectors.toList());
        if (CollectionUtils.isEmpty(cartList)) {
            return ResponseVo.error(ResponseEnum.CART_SELECTED_IS_EMPTY);
        }

        //获取cartList里的productIds
        Set<Integer> productIdSet = cartList.stream()
                .map(Cart::getProductId)
                .collect(Collectors.toSet());
        List<Product> productList = productMapper.selectByProductIdSet(productIdSet);
        Map<Integer, Product> map = productList.stream()
                .collect(Collectors.toMap(Product::getId, product -> product));

        for (Cart cart : cartList) {
            //根据productId查询数据库
            Product product = map.get(cart.getProductId());
            //是否有商品
            if (product ==null) {
                return ResponseVo.error(ResponseEnum.PRODUCT_NOT_EXIST,
                        "商品不存在. productId =" + cart.getProductId());
            }
            //商品上下架状态
            if (ProductStatusEnum.OFF_SALE.getCode().equals(product.getStatus())) {
                return ResponseVo.error(ResponseEnum.PRODUCT_NOT_EXIST);
            }
            //库存是否充足
            if (product.getStock() < cart.getQuantity()) {
                return ResponseVo.error(ResponseEnum.PRODUCT_STOCK_ERROR,
                        "库存有误." + product.getName());
            }
        }

        //计算总价，只计算选中的

        //生成订单，入库：order和order_item，事务

        //减库存

        //更新购物车（选中的商品）

        //构造orderVo

        return null;
    }
}
