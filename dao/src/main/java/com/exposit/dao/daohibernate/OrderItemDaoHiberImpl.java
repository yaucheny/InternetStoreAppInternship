package com.exposit.dao.daohibernate;

import com.exposit.api.dao.OrderItemDao;
import com.exposit.model.db.OrderItemDb;

public class OrderItemDaoHiberImpl extends AbstractDaoHiberImpl<OrderItemDb> implements OrderItemDao {

    @Override
    public void save(OrderItemDb entity) {
        if (entity.getId() == null) {
            this.entityManager.persist(entity);
        }
    }

    @Override
    protected Class<OrderItemDb> getClazz() {
        return OrderItemDb.class;
    }
}
