package com.exposit.dao.daoxml;

import com.exposit.api.dao.OrderItemDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.xml.MarshallingOrderItemXml;
import com.exposit.model.OrderItemEntity;

import java.util.List;

public class OrderItemDaoXmlImpl extends AbstractDaoXmlImpl<OrderItemEntity>
        implements OrderItemDao {

    public OrderItemDaoXmlImpl() {
        List<OrderItemEntity> orderItem = MarshallingOrderItemXml
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
