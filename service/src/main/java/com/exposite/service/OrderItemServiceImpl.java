package com.exposite.service;

import com.exposit.api.dao.OrderItemDao;
import com.exposit.api.service.OrderItemService;
import com.exposit.dto.OrderItemDto;
import com.exposit.exceptions.DaoException;
import com.exposit.exceptions.ServiceException;
import com.exposit.marshelling.json.MarshallingOrderItemJson;
import com.exposit.model.OrderItemEntity;
import lombok.extern.log4j.Log4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Log4j
@Service
public class OrderItemServiceImpl implements OrderItemService {
    private final ModelMapper mapper;
    private final OrderItemDao orderItemDao;


    private static final String CAN_NOT_DELETE_ORDER_ITEM
            = "can not delete orderItem";
    private static final String CAN_NOT_UPDATE_ORDER_ITEM
            = "can not update orderItem";
    private static final String CAN_NOT_ADD_ORDER_ITEM
            = "can not add orderItem";

    @Autowired
    public OrderItemServiceImpl(ModelMapper mapper, OrderItemDao orderItemDao) {
        this.mapper = mapper;
        this.orderItemDao = orderItemDao;
    }

    @Override
    public void addOrderItem(OrderItemDto orderItemDto) {
        if (orderItemDto.getId() == null) {
            OrderItemEntity orderItem = mapper
                    .map(orderItemDto, OrderItemEntity.class);
            orderItemDao.save(orderItem);
        } else {
            log.warn(CAN_NOT_ADD_ORDER_ITEM);
            throw new DaoException(CAN_NOT_ADD_ORDER_ITEM);
        }
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
    public void updateOrderItem(Long id, OrderItemDto orderItemDto) {
        if (orderItemDao.getById(id) != null) {
            OrderItemEntity orderItem = mapper
                    .map(orderItemDto, OrderItemEntity.class);
            orderItem.setId(id);
            orderItemDao.update(id, orderItem);
        } else {
            log.warn(CAN_NOT_UPDATE_ORDER_ITEM);
            throw new ServiceException(CAN_NOT_UPDATE_ORDER_ITEM);
        }
    }

    @Override
    public OrderItemDto getOrderItemById(Long id) {
        OrderItemEntity orderItem = orderItemDao.getById(id);
        return mapper.map(orderItem, OrderItemDto.class);
    }

    @Override
    public List<OrderItemDto> getAllOrderItem() {
        List<OrderItemEntity> orderItemEntityList = orderItemDao.getAll();
        Type listType = new TypeToken<List<OrderItemDto>>() {
        }.getType();
        return mapper.map(orderItemEntityList, listType);
    }

    @Override
    public void saveOrderItemToFile() {
        MarshallingOrderItemJson
                .serializeOrderItem(orderItemDao.getAll());
    }
}
