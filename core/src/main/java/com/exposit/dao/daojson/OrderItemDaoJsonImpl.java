package com.exposit.dao.daojson;

import com.exposit.api.dao.OrderItemDao;
import com.exposit.utils.idgenerators.IdGenerator;
import com.exposit.utils.marshelling.json.MarshallingOrderItemJson;
import com.exposit.domain.model.db.OrderItemDb;

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

    @Override
    public void saveToFile(List<OrderItemDb> entity) {

    }

    private void autoLoad(OrderItemDb entity) {
        repository.add(entity);
    }

}
