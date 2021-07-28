package com.exposit.api.service;

import com.exposit.dto.OrderDto;

import java.util.List;

public interface OrderService {

    void addOrder(OrderDto orderDto);

    void deleteOrder(Long id);

    void updateOrder(Long id, OrderDto orderDto);


    OrderDto getOrderById(Long id);

    List<OrderDto> getAllOrder();

    void saveOrderToFile();
}
