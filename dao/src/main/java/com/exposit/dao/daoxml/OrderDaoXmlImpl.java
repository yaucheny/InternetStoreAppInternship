package com.exposit.dao.daoxml;

import com.exposit.api.dao.OrderDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.xml.MarshallingOrderXml;
import com.exposit.model.OrderEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("orderItemXml")
public class OrderDaoXmlImpl extends AbstractDaoXmlImpl<OrderEntity> implements OrderDao {

    private OrderDao orderDao;

    public OrderDaoXmlImpl() {
        List<OrderEntity> order = MarshallingOrderXml
                .deSerializeOrder();
        for (OrderEntity entity : order) {
            this.save(entity);
        }
        IdGenerator.setOrderId((long) order.size()+1);
    }

    @Override
    public void save(OrderEntity entity) {
        entity.setId(IdGenerator.generateOrderId());
        repository.add(entity);
    }
}
