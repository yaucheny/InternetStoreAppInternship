package com.exposit.dao.daojson;

import com.exposit.api.dao.OrderDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.json.MarshallingOrderJson;
import com.exposit.model.OrderEntity;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository("orderjson")
public class OrderDaoJsonImpl
        extends AbstractDaoJsonImpl<OrderEntity> implements OrderDao {

    public OrderDaoJsonImpl() {
        List<OrderEntity> order = MarshallingOrderJson.deSerializeOrder();
        for (OrderEntity entity : order) {
            this.save(entity);
        }
        IdGenerator.setOrderId((long) order.size() + 1);
    }

    @Override
    public void save(OrderEntity entity) {
        entity.setId(IdGenerator.generateOrderId());
        repository.add(entity);
    }
}
