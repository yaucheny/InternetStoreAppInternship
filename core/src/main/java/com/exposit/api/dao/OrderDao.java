package com.exposit.api.dao;

import com.exposit.domain.model.db.OrderDb;

import java.util.List;

public interface OrderDao extends GenericDao<OrderDb> {

    void save(OrderDb entity);

    void saveToFile(List<OrderDb> entity);
}
