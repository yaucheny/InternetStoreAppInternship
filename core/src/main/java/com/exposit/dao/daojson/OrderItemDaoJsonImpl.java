package com.exposit.dao.daojson;

import com.exposit.api.dao.OrderItemDao;
import com.exposit.domain.model.db.OrderItemDb;
import com.exposit.utils.idgenerators.IdGenerator;
import com.exposit.utils.marshelling.MarshallingJson;

import java.util.List;
/**
 * Implementation of {@link OrderItemDao} interface.
 * Implementation works with Jackson API and json format files
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public class OrderItemDaoJsonImpl extends AbstractDaoJsonImpl<OrderItemDb> implements OrderItemDao {

    public OrderItemDaoJsonImpl() {
        List<OrderItemDb> orderItem = MarshallingJson.deserializeJsonEntity(OrderItemDb.class);
        for (OrderItemDb entity : orderItem) {
            this.autoLoad(entity);
        }
        IdGenerator.setOrderItemId((long) orderItem.size() + 1);
    }

    @Override
    public void save(OrderItemDb entity) {
        entity.setId(IdGenerator.generateOrderItemId());
        repository.add(entity);
    }
}
