package com.exposit.service;

import com.exposit.api.dao.OrderDao;
import com.exposit.api.service.OrderService;
import com.exposit.domain.dto.OrderDto;
import com.exposit.domain.model.db.OrderDb;
import com.exposit.domain.model.db.OrderItemDb;
import com.exposit.domain.model.db.ShopProductDb;
import com.exposit.domain.model.entity.OrderStatusEntity;
import com.exposit.utils.exceptions.DaoException;
import com.exposit.utils.exceptions.NotFoundException;
import com.exposit.utils.exceptions.ServiceException;
import com.exposit.utils.exceptions.ValidationException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

/**
 * Implementation of {@link OrderService} interface.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);
    private final ModelMapper mapper;
    private final OrderDao orderDao;
    private static final String CAN_NOT_DELETE_ORDER = "can not delete order";
    private static final String CAN_NOT_UPDATE_ORDER = "can not update order";
    private static final String CAN_NOT_ADD_ORDER = "can not add order ";
    private static final String NOT_ENOUGH_PRODUCTS = "not enough quantity of product in this store ";
    private static final String WRONG_DATA = "check values of data in update request ";

    @Override
    public void addOrder(OrderDto orderDto) {
        if (orderDto.getId() == null) {
            try {
                OrderDb order = new OrderDb();
                LocalDate dateOfOrder = LocalDate.now();
                order.setDateOfOrder(dateOfOrder);
                order.setDateOfDelivery(dateOfOrder.plusDays(orderDto.getDays()));
                order.setCustomer(orderDto.getCustomer());
                checkQuantity(orderDto.getOrderItemList());
                order.setOrderItemList(orderDto.getOrderItemList());
                order.setDays(orderDto.getDays());
                order.setPriceOfPurchase(priceOfBusket(orderDto.getOrderItemList()));
                order.setOrderStatusEntity(OrderStatusEntity.NOT_DELIVERED);
                changeQuantityAfterPurchase(orderDto.getOrderItemList());
                orderDao.save(order);
                mapper.map(orderDto, OrderDb.class);
            } catch (Exception e) {
                LOG.error(CAN_NOT_ADD_ORDER);
                throw new ServiceException(CAN_NOT_ADD_ORDER, e);
            }
        }
    }

    @Override
    public void deleteOrder(Long id) {
        try {
            orderDao.delete(orderDao.getById(id));
        } catch (DaoException e) {
            LOG.error(CAN_NOT_DELETE_ORDER);
            throw new ServiceException(CAN_NOT_DELETE_ORDER, e);
        }
    }

    @Override
    public void updateOrder(Long id, OrderDto orderDto) {
        if (orderDao.getById(id) != null) {
            try {
                OrderDb order = orderDao.getById(id);
                order.setDateOfOrder(orderDto.getDateOfOrder());
                order.setDays(orderDto.getDays());
                order.setDateOfDelivery(order.getDateOfOrder().plusDays(orderDto.getDays()));
                order.setCustomer(orderDto.getCustomer());
                order.setOrderItemList(orderDto.getOrderItemList());
                order.setDays(orderDto.getDays());
                order.setOrderStatusEntity(orderDto.getOrderStatusEntity());
                order.setPriceOfPurchase(priceOfBusket(order.getOrderItemList()));
                changeQuantityAfterPurchase(orderDto.getOrderItemList());
                checkQuantity(orderDto.getOrderItemList());
                orderDao.update(id, order);
            } catch (NotFoundException e) {
                LOG.error(CAN_NOT_UPDATE_ORDER);
                throw new ServiceException(CAN_NOT_UPDATE_ORDER, e);
            }
        }
    }

    @Override
    public OrderDto getOrderById(Long id) {
        OrderDb orderDb = orderDao.getById(id);
        return mapper.map(orderDb, OrderDto.class);
    }

    @Override
    public List<OrderDto> getAllOrder() {
        List<OrderDb> orderDbList = orderDao.getAll();
        Type listType = new TypeToken<List<OrderDto>>() {
        }.getType();
        return mapper.map(orderDbList, listType);
    }

    @Override
    public void saveOrderToFile() {
        orderDao.saveToFile(orderDao.getAll());
    }

    private Double priceOfBusket(List<OrderItemDb> orderItemList) {
        double priceOfBusket = 0;
        for (OrderItemDb orderItem : orderItemList) {
            double price = orderItem.getShopProduct().getPrice() * orderItem.getQuantity();
            priceOfBusket = priceOfBusket + price;
        }
        return priceOfBusket;
    }

    private void checkQuantity(List<OrderItemDb> orderItemList) {
        for (OrderItemDb orderItem : orderItemList) {
            Integer quantityList = orderItem.getQuantity();
            Integer quantityProduct = orderItem.getShopProduct().getQuantity();
            if (quantityProduct < quantityList) {
                LOG.error(NOT_ENOUGH_PRODUCTS);
                throw new ValidationException(NOT_ENOUGH_PRODUCTS);
            }
        }
    }

    private void changeQuantityAfterPurchase(
            List<OrderItemDb> orderItemList) {
        for (OrderItemDb orderItem : orderItemList) {
            Integer quantityList = orderItem.getQuantity();
            ShopProductDb shopProduct = orderItem.getShopProduct();
            Integer resultQuantity = shopProduct.getQuantity() - quantityList;
            shopProduct.setQuantity(resultQuantity);
        }
    }
}
