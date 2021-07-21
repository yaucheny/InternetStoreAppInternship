package com.exposit.api.dao;

import com.exposit.model.OrderEntity;

public interface OrderDao extends GenericDao<OrderEntity> {

    void save(OrderEntity entity);
}
