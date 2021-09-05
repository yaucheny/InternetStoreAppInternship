package com.exposit.api.service;

import com.exposit.domain.dto.OrderItemDto;

import java.util.List;
/**
 * Service interface for{@link com/exposit/domain/model/db/OrderItemDb.java}.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public interface OrderItemService {

    void addOrderItem(OrderItemDto orderItemDto);

    void deleteOrderItem(Long id);

    void updateOrderItem(Long id, OrderItemDto orderItemDto);

    OrderItemDto getOrderItemById(Long id);

    List<OrderItemDto> getAllOrderItem();

    void saveOrderItemToFile();
}
