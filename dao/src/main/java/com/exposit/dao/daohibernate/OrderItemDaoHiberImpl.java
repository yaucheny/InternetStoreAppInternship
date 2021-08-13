package com.exposit.dao.daohibernate;

import com.exposit.api.dao.OrderItemDao;
import com.exposit.model.db.OrderItemDb;

import java.util.List;

public class OrderItemDaoHiberImpl extends AbstractDaoHiberImpl<OrderItemDb> implements OrderItemDao {

    @Override
    protected Class<OrderItemDb> getClazz() {
        return OrderItemDb.class;
    }

    @Override
    public void save(OrderItemDb entity) {
        if (entity.getId() == null) {
            this.entityManager.persist(entity);
        }
    }

    @Override
    public void saveToFile(List<OrderItemDb> entity) {

    }
}
