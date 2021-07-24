package com.exposite.service;

import com.exposit.api.dao.OrderDao;
import com.exposit.api.service.OrderService;
import com.exposit.dao.util.DaoPropertiesHandler;
import com.exposit.dao.util.OrderDaoFactory;
import com.exposit.exceptions.DaoException;
import com.exposit.exceptions.ServiceException;
import com.exposit.marshelling.json.MarshallingOrderJson;
import com.exposit.model.CustomerEntity;
import com.exposit.model.OrderEntity;
import com.exposit.model.OrderItemEntity;
import com.exposit.model.ShopProductEntity;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Log4j
@Service
public class OrderServiceImpl implements OrderService {

    private static final String PROPERTY;

    static {
        PROPERTY = DaoPropertiesHandler.getProperty("dao.serialization.config_dao_impl")
                .orElseThrow(() -> new ServiceException("Serialization path not found"));
    }

    private final OrderDao orderDao;
    private static OrderServiceImpl instance;
    private static final String CAN_NOT_DELETE_ORDER = "can not delete order";
    private static final String CAN_NOT_UPDATE_ORDER = "can not update order";
    private static final String CAN_NOT_ADD_ORDER = "can not add order ";
    private static final String NOT_ENOUGH_PRODUCTS
            = "Not enough quantity of product in this store ";

    private OrderServiceImpl() {
        orderDao = OrderDaoFactory
                .getOrderDaoFromProperties(PROPERTY);
    }

    public static OrderServiceImpl getInstance() {
        if (instance == null) {
            instance = new OrderServiceImpl();
        }
        return instance;
    }

    @Override
    public OrderEntity addOrder(Long days, CustomerEntity customer,
                                List<OrderItemEntity> orderItemList) {
        try {
            OrderEntity order = new OrderEntity();
            LocalDate dateOfOrder = LocalDate.now();
            order.setDateOfOrder(dateOfOrder);
            order.setDateOfDelivery(dateOfOrder.plusDays(days));
            order.setPriceOfPurchase(instance.priceOfBusket(orderItemList));
            order.setCustomer(customer);
            checkQuantity(orderItemList);
            order.setOrderItemList(orderItemList);

            instance.changeQuantityAfterPurchase(orderItemList);
            orderDao.save(order);
            return order;
        } catch (ServiceException e) {
            log.warn(CAN_NOT_ADD_ORDER);
            throw new ServiceException(CAN_NOT_ADD_ORDER, e);
        }
    }

    @Override
    public void deleteOrder(Long id) {
        try {
            orderDao.delete(orderDao.getById(id));
        } catch (DaoException e) {
            log.warn(CAN_NOT_DELETE_ORDER, e);
            throw new ServiceException(CAN_NOT_DELETE_ORDER, e);
        }
    }

    @Override
    public void updateOrder(Long id, Long days, CustomerEntity customer,
                            List<OrderItemEntity> orderItemList) {
        if (orderDao.getById(id) != null) {
            try {
                OrderEntity order = new OrderEntity();
                LocalDate dateOfOrder = LocalDate.now();
                order.setId(id);
                order.setDateOfOrder(dateOfOrder);
                order.setDateOfDelivery(dateOfOrder.plusDays(days));
                order.setCustomer(customer);
                checkQuantity(orderItemList);
                order.setOrderItemList(orderItemList);

                order.setPriceOfPurchase(instance.priceOfBusket(orderItemList));
                instance.changeQuantityAfterPurchase(orderItemList);
                orderDao.update(id, order);
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
    public OrderEntity getOrderById(Long id) {
        return orderDao.getById(id);
    }

    @Override
    public List<OrderEntity> getAllOrder() {
        return orderDao.getAll();
    }

    @Override
    public void saveOrderToFile() {
        MarshallingOrderJson.serializeOrder(orderDao.getAll());
    }

    private Integer priceOfBusket(List<OrderItemEntity> orderItemList) {
        int priceOfBusket = 0;
        for (OrderItemEntity orderItem : orderItemList) {
            int price = orderItem.getShopProduct().getPrice()
                    * orderItem.getQuantity();
            priceOfBusket = priceOfBusket + price;
        }
        return priceOfBusket;
    }

    private void checkQuantity(List<OrderItemEntity> orderItemList) {
        for (OrderItemEntity orderItem : orderItemList) {
            Integer quantityList = orderItem.getQuantity();
            Integer quantityProduct = orderItem.getShopProduct().getQuantity();
            if (quantityProduct < quantityList) {
                log.warn(NOT_ENOUGH_PRODUCTS);
                throw new ServiceException(NOT_ENOUGH_PRODUCTS);
            }
        }
    }

    private void changeQuantityAfterPurchase(List<OrderItemEntity> orderItemList) {
        for (OrderItemEntity orderItem : orderItemList) {
            Integer quantityList = orderItem.getQuantity();
            ShopProductEntity shopProduct = orderItem.getShopProduct();
            Integer resultQuantity = shopProduct.getQuantity() - quantityList;
            shopProduct.setQuantity(resultQuantity);
        }
    }
}
