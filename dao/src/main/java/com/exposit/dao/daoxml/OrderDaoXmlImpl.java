package com.exposit.dao.daoxml;

import com.exposit.api.dao.OrderDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.xml.MarshallingOrderXml;
import com.exposit.model.OrderEntity;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class OrderDaoXmlImpl extends AbstractDaoXmlImpl<OrderEntity> implements OrderDao {

    private static OrderDao instance;

    private OrderDaoXmlImpl() {
        List<OrderEntity> order = MarshallingOrderXml.deSerializeOrder();
        for (OrderEntity entity : order) {
            this.save(entity);
        }
    }

    public static OrderDao getInstance() {
        if (instance == null) {
            instance = new OrderDaoXmlImpl();
        }
        return instance;
    }

    @Override
    public void save(OrderEntity entity) {
        entity.setId(IdGenerator.generateOrderId());
        repository.add(entity);
    }
}
