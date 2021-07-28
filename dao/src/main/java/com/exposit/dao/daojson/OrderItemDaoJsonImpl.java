package com.exposit.dao.daojson;

import com.exposit.api.dao.OrderItemDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.json.MarshallingOrderItemJson;
import com.exposit.model.OrderItemEntity;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository("orderItemJson")
public class OrderItemDaoJsonImpl extends AbstractDaoJsonImpl<OrderItemEntity>
        implements OrderItemDao {

    private OrderItemDao orderItemDao;

    private OrderItemDaoJsonImpl() {
        List<OrderItemEntity> orderItem = MarshallingOrderItemJson
                .deSerializeOrderItem();
        for (OrderItemEntity entity : orderItem) {
            this.save(entity);
        }
    }

    @Override
    public void save(OrderItemEntity entity) {
        entity.setId(IdGenerator.generateOrderItemId());
        repository.add(entity);
    }
}
