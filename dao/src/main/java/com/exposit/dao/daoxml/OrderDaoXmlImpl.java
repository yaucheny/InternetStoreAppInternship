package com.exposit.dao.daoxml;

import com.exposit.api.dao.OrderDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.xml.MarshallingOrderXml;
import com.exposit.model.OrderEntity;

import java.util.List;

public class OrderDaoXmlImpl
        extends AbstractDaoXmlImpl<OrderEntity> implements OrderDao {

    public OrderDaoXmlImpl() {
        List<OrderEntity> order = MarshallingOrderXml
                .deSerializeOrder();
        for (OrderEntity entity : order) {
            this.autoLoad(entity);
        }
    }

    @Override
    public void save(OrderEntity entity) {
        entity.setId(IdGenerator.generateOrderId());
        repository.add(entity);
    }

    private void autoLoad(OrderEntity entity){
        repository.add(entity);
    }
}
