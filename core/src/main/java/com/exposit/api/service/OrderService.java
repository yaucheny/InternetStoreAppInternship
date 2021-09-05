package com.exposit.api.service;

import com.exposit.domain.dto.OrderDto;

import java.util.List;
/**
 * Service interface for{@link com/exposit/domain/model/db/OrderDb.java}.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public interface OrderService {

    void addOrder(OrderDto orderDto);

    void deleteOrder(Long id);

    void updateOrder(Long id, OrderDto orderDto);


    OrderDto getOrderById(Long id);

    List<OrderDto> getAllOrder();

    void saveOrderToFile();
}
