package com.exposit.dao.daoxml;

import com.exposit.api.dao.OrderDao;
import com.exposit.domain.model.db.OrderDb;
import com.exposit.utils.idgenerators.IdGenerator;
import com.exposit.utils.marshelling.MarshallingXml;

import java.util.List;

/**
 * Implementation of {@link OrderDao} interface.
 * Implementation works with Jackson API and xml format files
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public class OrderDaoXmlImpl extends AbstractDaoXmlImpl<OrderDb> implements OrderDao {

    public OrderDaoXmlImpl() {
        List<OrderDb> order = MarshallingXml.deserializeXmlEntity(OrderDb.class);
        for (OrderDb entity : order) {
            this.autoLoad(entity);
        }
        IdGenerator.setOrderId((long) order.size() + 1);
    }

    @Override
    public void save(OrderDb entity) {
        entity.setId(IdGenerator.generateOrderId());
        repository.add(entity);
    }
}
