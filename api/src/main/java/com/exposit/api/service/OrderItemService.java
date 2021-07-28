package com.exposit.api.service;

import com.exposit.dto.OrderItemDto;

import java.util.List;

public interface OrderItemService {

    void addOrderItem(OrderItemDto orderItemDto);

    void deleteOrderItem(Long id);

    void updateOrderItem(Long id, OrderItemDto orderItemDto);

    OrderItemDto getOrderItemById(Long id);

    List<OrderItemDto> getAllOrderItem();

    void saveOrderItemToFile();
}
