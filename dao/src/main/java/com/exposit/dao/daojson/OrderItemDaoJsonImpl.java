package com.exposit.dao.daojson;

import com.exposit.api.dao.OrderItemDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.json.MarshallingOrderItemJson;
import com.exposit.model.OrderItemEntity;

import java.util.List;

public class OrderItemDaoJsonImpl extends AbstractDaoJsonImpl<OrderItemEntity>
        implements OrderItemDao {

    public OrderItemDaoJsonImpl() {
        List<OrderItemEntity> orderItem = MarshallingOrderItemJson
                .deSerializeOrderItem();
        for (OrderItemEntity entity : orderItem) {
            this.autoLoad(entity);
        }
    }

    @Override
    public void save(OrderItemEntity entity) {
        entity.setId(IdGenerator.generateOrderItemId());
        repository.add(entity);
    }

    private void autoLoad(OrderItemEntity entity){
        repository.add(entity);
    }
}
