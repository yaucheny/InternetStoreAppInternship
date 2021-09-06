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
    /**
     * Returns OrderItem by id.
     *
     * @param orderItemDto dto object of saving OrderItem
     * @author Yauheni Markevich
     */
    void addOrderItem(OrderItemDto orderItemDto);

    /**
     * Deletes OrderItem.
     *
     * @param id OrderItem with id to delete
     * @throws com.exposit.utils.exceptions.ServiceException if OrderItem was not found
     * @author Yauheni Markevich
     */
    void deleteOrderItem(Long id);

    /**
     * Updates OrderItem.
     *
     * @param id           OrderItem with id to update
     * @param orderItemDto dto object of searching OrderItem
     * @throws com.exposit.utils.exceptions.ServiceException if OrderItem was not found
     * @author Yauheni Markevich
     */
    void updateOrderItem(Long id, OrderItemDto orderItemDto);

    /**
     * Returns OrderItem by id.
     *
     * @param id of searching OrderItem
     * @return OrderItemDto.
     * @throws com.exposit.utils.exceptions.ServiceException if OrderItem was not found
     * @author Yauheni Markevich
     */
    OrderItemDto getOrderItemById(Long id);

    /**
     * Gets List of OrderItems.
     *
     * @return List<OrderItemDto> of OrderItems or emptyList
     * @author Yauheni Markevich
     */
    List<OrderItemDto> getAllOrderItem();

    /**
     * Saves OrderItems to file.
     *
     * @author Yauheni Markevich
     */
    void saveOrderItemToFile();
}
