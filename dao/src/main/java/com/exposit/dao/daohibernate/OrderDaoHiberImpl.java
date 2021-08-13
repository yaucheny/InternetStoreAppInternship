package com.exposit.dao.daohibernate;

import com.exposit.api.dao.OrderDao;
import com.exposit.model.db.OrderDb;

import java.util.List;

public class OrderDaoHiberImpl extends AbstractDaoHiberImpl<OrderDb> implements OrderDao {

    @Override
    protected Class<OrderDb> getClazz() {
        return OrderDb.class;
    }

    @Override
    public void save(OrderDb entity) {
        if (entity.getId() == null) {
            this.entityManager.persist(entity);
        }
    }

    @Override
    public void saveToFile(List<OrderDb> entity) {

    }
}
