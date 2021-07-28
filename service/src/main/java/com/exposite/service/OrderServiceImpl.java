package com.exposite.service;

import com.exposit.api.dao.OrderDao;
import com.exposit.api.service.OrderService;
import com.exposit.dao.util.OrderDaoFactory;
import com.exposit.dto.OrderDto;
import com.exposit.exceptions.DaoException;
import com.exposit.exceptions.ServiceException;
import com.exposit.marshelling.json.MarshallingOrderJson;
import com.exposit.model.*;
import lombok.extern.log4j.Log4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exposit.dao.util.DaoPropertiesHandler;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@Log4j
@Service
public class OrderServiceImpl implements OrderService {
    private final ModelMapper mapper;
    private final OrderDao orderDao;
    private OrderServiceImpl orderService;

    private static final String CAN_NOT_DELETE_ORDER = "can not delete order";
    private static final String CAN_NOT_UPDATE_ORDER = "can not update order";
    private static final String CAN_NOT_ADD_ORDER = "can not add order ";
    private static final String NOT_ENOUGH_PRODUCTS
            = "Not enough quantity of product in this store ";

    @Autowired
    public OrderServiceImpl(ModelMapper mapper, OrderDao orderDao) {
        this.mapper = mapper;
        this.orderDao = orderDao;
    }

    @Override
    public void addOrder(OrderDto orderDto) {
        if (orderDto.getId() == null) {
            try {
                OrderEntity order = new OrderEntity();
                LocalDate dateOfOrder = LocalDate.now();
                order.setDateOfOrder(dateOfOrder);
                order.setDateOfDelivery(dateOfOrder.plusDays(orderDto.getDays()));
                order.setPriceOfPurchase(orderService.priceOfBusket(orderDto.getOrderItemList()));
                order.setCustomer(orderDto.getCustomer());
                checkQuantity(orderDto.getOrderItemList());
                order.setOrderItemList(orderDto.getOrderItemList());

                orderService.changeQuantityAfterPurchase(orderDto.getOrderItemList());
                orderDao.save(order);

                mapper.map(orderDto, OrderEntity.class);
            } catch (ServiceException e) {
                log.warn(CAN_NOT_UPDATE_ORDER, e);
                throw new ServiceException(CAN_NOT_UPDATE_ORDER, e);
            }
        } else {
            log.warn(CAN_NOT_ADD_ORDER);
            throw new DaoException(CAN_NOT_ADD_ORDER);
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
    public void updateOrder(Long id, OrderDto orderDto) {
        if (orderDao.getById(id) != null) {
            try {
                OrderEntity order = new OrderEntity();
                LocalDate dateOfOrder = LocalDate.now();
                order.setId(id);
                order.setDateOfOrder(dateOfOrder);
                order.setDateOfDelivery(dateOfOrder.plusDays(orderDto.getDays()));
                order.setCustomer(orderDto.getCustomer());
                checkQuantity(orderDto.getOrderItemList());
                order.setOrderItemList(orderDto.getOrderItemList());

                order.setPriceOfPurchase(orderService.priceOfBusket(orderDto.getOrderItemList()));
                orderService.changeQuantityAfterPurchase(orderDto.getOrderItemList());
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
    public OrderDto getOrderById(Long id) {

        OrderEntity orderEntity = orderDao.getById(id);
        return mapper.map(orderEntity, OrderDto.class);
    }

    @Override
    public List<OrderDto> getAllOrder() {
        List<OrderEntity> orderEntityList = orderDao.getAll();
        Type listType = new TypeToken<List<OrderDto>>() {
        }.getType();
        return mapper.map(orderEntityList, listType);
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
