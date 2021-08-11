package com.exposit.dao.daojson;

import com.exposit.api.dao.OrderItemDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.json.MarshallingOrderItemJson;
import com.exposit.model.db.OrderItemDb;

import java.util.List;

public class OrderItemDaoJsonImpl extends AbstractDaoJsonImpl<OrderItemDb> implements OrderItemDao {

    public OrderItemDaoJsonImpl() {
        List<OrderItemDb> orderItem = MarshallingOrderItemJson.deSerializeOrderItem();
        for (OrderItemDb entity : orderItem) {
            this.autoLoad(entity);
        }
    }

    @Override
    public void save(OrderItemDb entity) {
        entity.setId(IdGenerator.generateOrderItemId());
        repository.add(entity);
    }

    private void autoLoad(OrderItemDb entity) {
        repository.add(entity);
    }

}
