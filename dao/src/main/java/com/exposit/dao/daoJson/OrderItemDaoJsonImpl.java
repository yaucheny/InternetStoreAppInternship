package com.exposit.dao.daoJson;

import com.exposit.api.dao.OrderItemDao;
import com.exposit.idGenerators.IdGenerator;
import com.exposit.marshelling.json.MarshallingOrderItemJson;
import com.exposit.model.OrderItemEntity;

import java.util.List;

public class OrderItemDaoJsonImpl extends AbstractDaoJsonImpl<OrderItemEntity>
        implements OrderItemDao {

    private static OrderItemDaoJsonImpl instance;

    private OrderItemDaoJsonImpl() {
        List<OrderItemEntity> orderItem = MarshallingOrderItemJson
        .deSerializeOrderItem();
        for (OrderItemEntity entity : orderItem) {
 //           entity.setId(IdGenerator.generateOrderItemId());
            this.save(entity);
        }
    }

    public static OrderItemDao getInstance() {
        if (instance == null) {
            instance = new OrderItemDaoJsonImpl();
        }
        return instance;
    }

    @Override
    public void save(OrderItemEntity entity) {
        entity.setId(IdGenerator.generateOrderItemId());
        repository.add(entity);
    }
}
