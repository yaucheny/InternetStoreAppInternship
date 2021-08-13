package com.exposit.dao.daoxml;

import com.exposit.api.dao.OrderItemDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.xml.MarshallingOrderItemXml;
import com.exposit.model.db.OrderItemDb;

import java.util.List;

public class OrderItemDaoXmlImpl extends AbstractDaoXmlImpl<OrderItemDb> implements OrderItemDao {

    public OrderItemDaoXmlImpl() {
        List<OrderItemDb> orderItem = MarshallingOrderItemXml.deSerializeOrderItem();
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
