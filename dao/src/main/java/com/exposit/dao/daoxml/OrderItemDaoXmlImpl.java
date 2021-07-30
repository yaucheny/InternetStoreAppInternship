package com.exposit.dao.daoxml;

import com.exposit.api.dao.OrderItemDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.xml.MarshallingOrderItemXml;
import com.exposit.model.OrderItemEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("orderItemxml")
public class OrderItemDaoXmlImpl extends AbstractDaoXmlImpl<OrderItemEntity>
        implements OrderItemDao {

    private OrderItemDao orderItemDao;

    public OrderItemDaoXmlImpl() {
        List<OrderItemEntity> orderItem = MarshallingOrderItemXml
                .deSerializeOrderItem();
        for (OrderItemEntity entity : orderItem) {
            this.save(entity);
        }
        IdGenerator.setOrderItemId((long) orderItem.size()+1);
    }

    @Override
    public void save(OrderItemEntity entity) {
        entity.setId(IdGenerator.generateOrderItemId());
        repository.add(entity);
    }
}
