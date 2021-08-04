package com.exposit.dao.daojson;

import com.exposit.api.dao.OrderDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.json.MarshallingOrderJson;
import com.exposit.model.OrderEntity;

import java.util.List;

public class OrderDaoJsonImpl extends AbstractDaoJsonImpl<OrderEntity> implements OrderDao {

    public OrderDaoJsonImpl() {
        List<OrderEntity> order = MarshallingOrderJson.deSerializeOrder();
        for (OrderEntity entity : order) {
            this.autoLoad(entity);
        }
    }

    @Override
    public void save(OrderEntity entity) {
        entity.setId(IdGenerator.generateOrderId());
        repository.add(entity);
    }

    private void autoLoad(OrderEntity entity) {
        repository.add(entity);
    }
}
