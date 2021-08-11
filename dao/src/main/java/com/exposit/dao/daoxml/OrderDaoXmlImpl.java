package com.exposit.dao.daoxml;

import com.exposit.api.dao.OrderDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.xml.MarshallingOrderXml;
import com.exposit.model.db.OrderDb;

import java.util.List;

public class OrderDaoXmlImpl
        extends AbstractDaoXmlImpl<OrderDb> implements OrderDao {

    public OrderDaoXmlImpl() {
        List<OrderDb> order = MarshallingOrderXml.deSerializeOrder();
        for (OrderDb entity : order) {
            this.autoLoad(entity);
        }
    }

    @Override
    public void save(OrderDb entity) {
        entity.setId(IdGenerator.generateOrderId());
        repository.add(entity);
    }

    private void autoLoad(OrderDb entity) {
        repository.add(entity);
    }
}
