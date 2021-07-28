package com.exposit.dao.daoxml;

import com.exposit.api.dao.OrderDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.xml.MarshallingCategoryXml;
import com.exposit.marshelling.xml.MarshallingOrderXml;
import com.exposit.model.CategoryEntity;
import com.exposit.model.OrderEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("orderItemXml")
public class OrderDaoXmlImpl extends AbstractDaoXmlImpl<OrderEntity> implements OrderDao {

    private OrderDao orderDao;

    public OrderDaoXmlImpl() {
        List<OrderEntity> category = MarshallingOrderXml
                .deSerializeOrder();
        for (OrderEntity entity : category) {
            this.save(entity);
        }
    }

    @Override
    public void save(OrderEntity entity) {
        entity.setId(IdGenerator.generateOrderId());
        repository.add(entity);
    }
}
