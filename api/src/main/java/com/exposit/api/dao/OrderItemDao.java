package com.exposit.api.dao;

import com.exposit.model.OrderItemEntity;

public interface OrderItemDao extends GenericDao<OrderItemEntity> {
    void save(OrderItemEntity entity);
}
