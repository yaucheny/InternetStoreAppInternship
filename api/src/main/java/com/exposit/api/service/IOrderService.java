package com.exposit.api.service;

import com.exposit.model.Customer;
import com.exposit.model.Product;
import com.exposit.model.Order;

import java.util.List;
import java.util.Map;

public interface IOrderService {

    Order addOrder(Long days, Customer customer, Map<Product,Integer> mapOfGoods);

    void deleteOrder(Long orderId);

    void updateOrder(Long orderId,Long days,
                      Customer customer, Map<Product,Integer> mapOfGoods);


    Order getOrderById(Long orderId);

    List<Order> getAllOrder();

    void saveOrderToFile();
}
