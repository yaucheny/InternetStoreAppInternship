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
    /**
     * Returns Order by id.
     *
     * @param orderDto dto object of saving Order
     * @author Yauheni Markevich
     */
    void addOrder(OrderDto orderDto);

    /**
     * Deletes Order.
     *
     * @param id Order with id to delete
     * @throws com.exposit.utils.exceptions.ServiceException if Order was not found
     * @author Yauheni Markevich
     */
    void deleteOrder(Long id);

    /**
     * Updates Order.
     *
     * @param id       Order with id to update
     * @param orderDto dto object of searching Order
     * @throws com.exposit.utils.exceptions.ServiceException if Order was not found
     * @author Yauheni Markevich
     */
    void updateOrder(Long id, OrderDto orderDto);

    /**
     * Returns Order by id.
     *
     * @param id of searching Order
     * @return OrderDto.
     * @throws com.exposit.utils.exceptions.ServiceException if Order was not found
     * @author Yauheni Markevich
     */

    OrderDto getOrderById(Long id);

    /**
     * Gets List of Orders.
     *
     * @return List<OrderDto> of Orders or emptyList
     * @author Yauheni Markevich
     */
    List<OrderDto> getAllOrder();

    /**
     * Saves Orders to file.
     *
     * @author Yauheni Markevich
     */
    void saveOrderToFile();
}
