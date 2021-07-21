package com.exposit.api.service;

import com.exposit.model.CustomerEntity;
import com.exposit.model.OrderItemEntity;
import com.exposit.model.OrderEntity;

import java.util.List;

public interface OrderService {

    OrderEntity addOrder(Long days, CustomerEntity customer, List<OrderItemEntity> orderItems);

    void deleteOrder(Long id);

    void updateOrder(Long id, Long days,
                     CustomerEntity customer, List<OrderItemEntity> orderItems);


    OrderEntity getOrderById(Long id);

    List<OrderEntity> getAllOrder();

    void saveOrderToFile();
}
