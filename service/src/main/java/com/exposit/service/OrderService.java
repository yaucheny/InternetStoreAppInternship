package com.exposit.service;

import com.exposit.api.service.IOrderService;
import com.exposit.dao.OrderDao;
import com.exposit.dao.ProductDao;
import com.exposit.exceptions.DaoException;
import com.exposit.exceptions.ServiceException;
import com.exposit.marshelling.MarshallingJsonHandlerOrder;
import com.exposit.model.Customer;
import com.exposit.model.Product;
import com.exposit.model.Order;
import lombok.extern.log4j.Log4j;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Log4j
public class OrderService implements IOrderService {

    private final OrderDao orderDao;
    private final ProductDao productDao;
    private static OrderService instance;
    private static final String CAN_NOT_DELETE_ORDER = "can not delete order";
    private static final String CAN_NOT_UPDATE_ORDER = "can not update order";
    private static final String CAN_NOT_ADD_ORDER = "can not add order ";
    private static final String NOT_ENOUGH_PRODUCTS = "Not enough quantity of product in this store ";

    private OrderService() {
        orderDao = OrderDao.getInstance();
        productDao = ProductDao.getInstance();
    }

    public static OrderService getInstance() {
        if (instance == null) {
            instance = new OrderService();
        }
        return instance;
    }

    @Override
    public Order addOrder(Long days, Customer customer, Map<Product, Integer> mapOfproducts) {
        try {
            Order order = new Order();
            LocalDate dateOfOrder = LocalDate.now();
            order.setDateOfOrder(dateOfOrder);
            order.setDateOfDelivery(dateOfOrder.plusDays(days));
            order.setPriceOfPurchase(instance.priceOfBusket(mapOfproducts));
            order.setCustomer(customer);
            if (checkQuantity(mapOfproducts)) {
                order.setMapOfGoods(mapOfproducts);
            }
            instance.changeQuantityAfterPurchase(mapOfproducts);
            orderDao.save(order);
            return order;
        } catch (ServiceException e) {
            log.warn(CAN_NOT_ADD_ORDER);
            throw new ServiceException(CAN_NOT_ADD_ORDER, e);
        }
    }

    @Override
    public void deleteOrder(Long orderId) {
        try {
            orderDao.delete(orderDao.getById(orderId));
        } catch (DaoException e) {
            log.warn(CAN_NOT_DELETE_ORDER, e);
            throw new ServiceException(CAN_NOT_DELETE_ORDER, e);
        }
    }

    @Override
    public void updateOrder(Long orderId, Long days, Customer customer,
                            Map<Product, Integer> mapOfProducts) {
        if (orderDao.getById(orderId) != null) {
            try {
                Order order = new Order();
                LocalDate dateOfOrder = LocalDate.now();
                order.setId(orderId);
                order.setDateOfOrder(dateOfOrder);
                order.setDateOfDelivery(dateOfOrder.plusDays(days));
                order.setCustomer(customer);
                if (checkQuantity(mapOfProducts)) {
                    order.setMapOfGoods(mapOfProducts);
                }
                order.setPriceOfPurchase(instance.priceOfBusket(mapOfProducts));
                instance.changeQuantityAfterPurchase(mapOfProducts);
                orderDao.update(orderId, order);
            } catch (ServiceException e) {
                log.warn(CAN_NOT_UPDATE_ORDER, e);
                throw new ServiceException(CAN_NOT_UPDATE_ORDER, e);
            }
        } else {
            log.warn(CAN_NOT_UPDATE_ORDER);
            throw new ServiceException(CAN_NOT_UPDATE_ORDER);
        }
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderDao.getById(orderId);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderDao.getAll();
    }

    @Override
    public void saveOrderToFile() {
        MarshallingJsonHandlerOrder.serializeOrder(orderDao.getAll());
    }

    private Integer priceOfBusket(Map<Product, Integer> map) {
        Integer priceOfBusket = 0;
        for (Map.Entry<Product, Integer> entry : map.entrySet()) {
            Integer price = entry.getKey().getProductPrice() * entry.getValue();
            priceOfBusket = priceOfBusket + price;
        }
        return priceOfBusket;
    }

    private boolean checkQuantity(Map<Product, Integer> map) {
        for (Map.Entry<Product, Integer> entry : map.entrySet()) {
            Integer quantityMap = entry.getValue();
            Integer quantityProduct = entry.getKey().getProductQuantity();
            if (quantityProduct < quantityMap) {
                log.warn(NOT_ENOUGH_PRODUCTS);
                throw new ServiceException(NOT_ENOUGH_PRODUCTS);
            }
        }
        return true;
    }

    private void changeQuantityAfterPurchase(Map<Product, Integer> map) {
        for (Map.Entry<Product, Integer> entry : map.entrySet()) {
            Integer quantityMap = entry.getValue();
            Long productId = entry.getKey().getId();
            Product product = instance.productDao.getById(productId);
            Integer resultQuantity = product.getProductQuantity() - quantityMap;
            product.setProductQuantity(resultQuantity);
        }
    }
}
