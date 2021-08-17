package com.exposit.dao.daorepository;

import com.exposit.api.dao.OrderItemDao;
import com.exposit.domain.model.db.OrderItemDb;

import java.util.List;

public class OrderItemDaoRepositoryImpl implements OrderItemDao {
    @Override
    public void save(OrderItemDb entity) {

    }

    @Override
    public void saveToFile(List<OrderItemDb> entity) {

    }

    @Override
    public OrderItemDb getById(Long id) {
        return null;
    }

    @Override
    public void delete(OrderItemDb entity) {

    }

    @Override
    public void update(Long id, OrderItemDb entity) {

    }

    @Override
    public List<OrderItemDb> getAll() {
        return null;
    }
}
