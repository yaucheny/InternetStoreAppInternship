package com.exposit.dao.daoxml;

import com.exposit.api.dao.OrderItemDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.xml.MarshallingOrderItemXml;
import com.exposit.model.OrderItemEntity;

import java.util.List;

public class OrderItemDaoXmlImpl extends AbstractDaoXmlImpl<OrderItemEntity>
        implements OrderItemDao {

    private static OrderItemDaoXmlImpl instance;

    private OrderItemDaoXmlImpl() {
        List<OrderItemEntity> orderItem = MarshallingOrderItemXml
        .deSerializeOrderItem();
        for (OrderItemEntity entity : orderItem) {
            this.save(entity);
        }
    }

    public static OrderItemDao getInstance() {
        if (instance == null) {
            instance = new OrderItemDaoXmlImpl();
        }
        return instance;
    }

    @Override
    public void save(OrderItemEntity entity) {
        entity.setId(IdGenerator.generateOrderItemId());
        repository.add(entity);
    }
}
