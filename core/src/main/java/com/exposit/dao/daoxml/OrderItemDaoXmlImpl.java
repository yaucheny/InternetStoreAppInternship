package com.exposit.dao.daoxml;

import com.exposit.api.dao.OrderItemDao;
import com.exposit.domain.model.db.OrderItemDb;
import com.exposit.utils.idgenerators.IdGenerator;
import com.exposit.utils.marshelling.MarshallingXml;

import java.util.List;

/**
 * Implementation of {@link OrderItemDao} interface.
 * Implementation works with Jackson API and xml format files
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public class OrderItemDaoXmlImpl extends AbstractDaoXmlImpl<OrderItemDb> implements OrderItemDao {

    public OrderItemDaoXmlImpl() {
        List<OrderItemDb> orderItem = MarshallingXml.deserializeXmlEntity(OrderItemDb.class);
        for (OrderItemDb entity : orderItem) {
            this.autoLoad(entity);
        }
        IdGenerator.setOrderId((long) orderItem.size() + 1);
    }

    @Override
    public void save(OrderItemDb entity) {
        entity.setId(IdGenerator.generateOrderItemId());
        repository.add(entity);
    }
}
