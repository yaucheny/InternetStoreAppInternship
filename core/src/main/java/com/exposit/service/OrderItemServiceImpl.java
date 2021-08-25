package com.exposit.service;

import com.exposit.api.dao.OrderItemDao;
import com.exposit.api.service.OrderItemService;
import com.exposit.domain.dto.OrderItemDto;
import com.exposit.domain.model.db.OrderItemDb;
import com.exposit.utils.exceptions.DaoException;
import com.exposit.utils.exceptions.ServiceException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderItemServiceImpl implements OrderItemService {

    private static final Logger log = LoggerFactory.getLogger(OrderItemServiceImpl.class);
    private final ModelMapper mapper;
    private final OrderItemDao orderItemDao;
    private static final String CAN_NOT_DELETE_ORDER_ITEM = "can not delete orderItem";
    private static final String CAN_NOT_UPDATE_ORDER_ITEM = "can not update orderItem";
    private static final String CAN_NOT_ADD_ORDER_ITEM = "can not add orderItem";

    @Override
    public void addOrderItem(OrderItemDto orderItemDto) {
        if (orderItemDto.getId() == null) {
            OrderItemDb orderItem = mapper.map(orderItemDto, OrderItemDb.class);
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
            log.warn(CAN_NOT_DELETE_ORDER_ITEM);
            throw new ServiceException(CAN_NOT_DELETE_ORDER_ITEM, e);
        }
    }

    @Override
    public void updateOrderItem(Long id, OrderItemDto orderItemDto) {
        if (orderItemDao.getById(id) != null) {
            OrderItemDb orderItem = mapper.map(orderItemDto, OrderItemDb.class);
            orderItem.setId(id);
            orderItemDao.update(id, orderItem);
        } else {
            log.warn(CAN_NOT_UPDATE_ORDER_ITEM);
            throw new ServiceException(CAN_NOT_UPDATE_ORDER_ITEM);
        }
    }

    @Override
    public OrderItemDto getOrderItemById(Long id) {
        OrderItemDb orderItem = orderItemDao.getById(id);
        return mapper.map(orderItem, OrderItemDto.class);
    }

    @Override
    public List<OrderItemDto> getAllOrderItem() {
        List<OrderItemDb> orderItemDbList = orderItemDao.getAll();
        Type listType = new TypeToken<List<OrderItemDto>>() {
        }.getType();
        return mapper.map(orderItemDbList, listType);
    }

    @Override
    public void saveOrderItemToFile() {
        orderItemDao.saveToFile(orderItemDao.getAll());
    }
}
