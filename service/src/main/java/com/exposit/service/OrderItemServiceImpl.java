package com.exposit.service;

import com.exposit.api.dao.OrderItemDao;
import com.exposit.api.service.OrderItemService;
import com.exposit.dao.util.DaoPropertiesHandler;
import com.exposit.dao.util.OrderItemDaoFactory;
import com.exposit.exceptions.DaoException;
import com.exposit.exceptions.ServiceException;
import com.exposit.marshelling.json.MarshallingOrderItemJson;
import com.exposit.model.OrderItemEntity;
import com.exposit.model.ShopProductEntity;
import lombok.extern.log4j.Log4j;

import java.util.List;

@Log4j
public class OrderItemServiceImpl implements OrderItemService {

    private static final String PROPERTY = DaoPropertiesHandler.getProperty("dao.serialization.config_dao_impl").orElseThrow(() -> new ServiceException("Serialization path not found"));;
    private final OrderItemDao orderItemDao;
    private static OrderItemServiceImpl instance;
    private static final String CAN_NOT_DELETE_ORDER_ITEM
            = "can not delete orderItem";
    private static final String CAN_NOT_UPDATE_ORDER_ITEM
            = "can not update orderItem";

    public OrderItemServiceImpl() {
        orderItemDao = OrderItemDaoFactory.getOrderItemDaoFromProperties(PROPERTY);
    }

    public static OrderItemServiceImpl getInstance() {
        if (instance == null) {
            instance = new OrderItemServiceImpl();
        }
        return instance;
    }

    @Override
    public OrderItemEntity addOrderItem(ShopProductEntity shopProduct,
                                        Integer quantityInOrder) {
        OrderItemEntity orderItem = new OrderItemEntity(shopProduct, quantityInOrder);
        orderItemDao.save(orderItem);
        return orderItem;
    }

    @Override
    public void deleteOrderItem(Long id) {
        try {
            orderItemDao.delete(orderItemDao.getById(id));
        } catch (DaoException e) {
            log.warn(CAN_NOT_DELETE_ORDER_ITEM, e);
            throw new ServiceException(CAN_NOT_DELETE_ORDER_ITEM, e);
        }
    }

    @Override
    public void updateOrderItem(Long id, ShopProductEntity shopProduct,
                                Integer quantityInOrder) {
        if (orderItemDao.getById(id) != null) {
            OrderItemEntity orderItem = new OrderItemEntity(id,
                    shopProduct, quantityInOrder);
            orderItem.setId(id);
            orderItemDao.update(id, orderItem);
        } else {
            log.warn(CAN_NOT_UPDATE_ORDER_ITEM);
            throw new ServiceException(CAN_NOT_UPDATE_ORDER_ITEM);
        }
    }

    @Override
    public OrderItemEntity getOrderItemById(Long id) {
        return orderItemDao.getById(id);
    }

    @Override
    public List<OrderItemEntity> getAllOrderItem() {
        return orderItemDao.getAll();
    }

    @Override
    public void saveOrderItemToFile() {
        MarshallingOrderItemJson
                .serializeOrderItem(orderItemDao.getAll());
    }
}
