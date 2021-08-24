package com.exposit.dao.daojson;

import com.exposit.api.dao.OrderDao;
import com.exposit.domain.model.db.OrderDb;
import com.exposit.utils.idgenerators.IdGenerator;
import com.exposit.utils.marshelling.MarshallingJson;

import java.util.List;

public class OrderDaoJsonImpl extends AbstractDaoJsonImpl<OrderDb> implements OrderDao {

    public OrderDaoJsonImpl() {
        List<OrderDb> order = MarshallingJson.deserializeJsonEntity(OrderDb.class);
        for (OrderDb entity : order) {
            this.autoLoad(entity);
        }
        IdGenerator.setOrderId((long) order.size() + 1);
    }

    @Override
    public void save(OrderDb entity) {
        entity.setId(IdGenerator.generateOrderId());
        repository.add(entity);
    }
}
