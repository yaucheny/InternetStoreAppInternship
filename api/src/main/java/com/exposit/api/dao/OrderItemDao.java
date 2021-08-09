package com.exposit.api.dao;

import com.exposit.model.db.OrderItemDb;

public interface OrderItemDao extends GenericDao<OrderItemDb> {

    void save(OrderItemDb entity);
}
