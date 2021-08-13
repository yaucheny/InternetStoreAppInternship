package com.exposit.api.dao;

import com.exposit.model.db.OrderItemDb;

import java.util.List;

public interface OrderItemDao extends GenericDao<OrderItemDb> {

    void save(OrderItemDb entity);

    void saveToFile(List<OrderItemDb> entity);
}
