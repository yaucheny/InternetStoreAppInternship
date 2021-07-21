package com.exposit.api.service;

import com.exposit.model.OrderItemEntity;
import com.exposit.model.ShopProductEntity;

import java.util.List;

public interface OrderItemService {

    OrderItemEntity addOrderItem(ShopProductEntity shopProduct, Integer quantityInOrder);

    void deleteOrderItem(Long id);

    void updateOrderItem(Long id, ShopProductEntity shopProduct,
                         Integer quantityInOrder);

    OrderItemEntity getOrderItemById(Long id);

    List<OrderItemEntity> getAllOrderItem();

    void saveOrderItemToFile();
}
