package com.exposit.dao.daorepository;

import com.exposit.api.dao.OrderDao;
import com.exposit.domain.model.db.OrderDb;

import java.util.List;

public class OrderDaoRepositoryImpl implements OrderDao {
    @Override
    public void save(OrderDb entity) {

    }

    @Override
    public void saveToFile(List<OrderDb> entity) {

    }

    @Override
    public OrderDb getById(Long id) {
        return null;
    }

    @Override
    public void delete(OrderDb entity) {

    }

    @Override
    public void update(Long id, OrderDb entity) {

    }

    @Override
    public List<OrderDb> getAll() {
        return null;
    }
}
