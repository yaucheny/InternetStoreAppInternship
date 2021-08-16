package com.exposit.dao.daojson;

import com.exposit.api.dao.OrderDao;
import com.exposit.utils.idgenerators.IdGenerator;
import com.exposit.utils.marshelling.json.MarshallingOrderJson;
import com.exposit.domain.model.db.OrderDb;

import java.util.List;

public class OrderDaoJsonImpl extends AbstractDaoJsonImpl<OrderDb> implements OrderDao {

    public OrderDaoJsonImpl() {
        List<OrderDb> order = MarshallingOrderJson.deSerializeOrder();
        for (OrderDb entity : order) {
            this.autoLoad(entity);
        }
    }

    @Override
    public void save(OrderDb entity) {
        entity.setId(IdGenerator.generateOrderId());
        repository.add(entity);
    }

    @Override
    public void saveToFile(List<OrderDb> entity) {

    }

    private void autoLoad(OrderDb entity) {
        repository.add(entity);
    }
}
