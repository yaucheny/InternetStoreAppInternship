package com.exposit.api.dao;

import com.exposit.model.Order;

public interface IOrderDao extends IGenericDao<Order> {

    void save(Order entity);
}
