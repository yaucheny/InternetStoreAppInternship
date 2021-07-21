package com.exposit.dao.daoXml;

import com.exposit.api.dao.OrderDao;
import com.exposit.idGenerators.IdGenerator;
import com.exposit.marshelling.Xml.MarshallingOrderXml;
import com.exposit.marshelling.json.MarshallingOrderJson;
import com.exposit.model.OrderEntity;

import java.util.List;


public class OrderDaoXmlImpl extends AbstractDaoXmlImpl<OrderEntity> implements OrderDao {

    private static OrderDao instance;

    private OrderDaoXmlImpl() {
        List<OrderEntity> order = MarshallingOrderXml.deSerializeOrder();
        for (OrderEntity entity : order) {
//            entity.setId(IdGenerator.generateOrderId());
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
