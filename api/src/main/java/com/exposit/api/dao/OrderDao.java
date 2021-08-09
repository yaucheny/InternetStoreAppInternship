package com.exposit.api.dao;

import com.exposit.model.db.OrderDb;

public interface OrderDao extends GenericDao<OrderDb> {

    void save(OrderDb entity);
}
