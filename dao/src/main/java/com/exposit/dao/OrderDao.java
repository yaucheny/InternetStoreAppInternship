package com.exposit.dao;

import com.exposit.api.dao.IOrderDao;
import com.exposit.idGenerators.IdGenerator;
import com.exposit.marshelling.UnMarshallingJsonHandlerCustomer;
import com.exposit.marshelling.UnMarshallingJsonHandlerOrder;
import com.exposit.model.Customer;
import com.exposit.model.Order;

import java.util.List;

public class OrderDao extends AbstractDao<Order> implements IOrderDao {

    private static OrderDao instance;

    private OrderDao() {
        List<Order> order = UnMarshallingJsonHandlerOrder.deSerializeOrder();
        for (Order entity : order) {
            entity.setId(IdGenerator.generateOrderId());
            this.save(entity);
        }
    }

    public static OrderDao getInstance() {
        if (instance == null) {
            instance = new OrderDao();
        }
        return instance;
    }

    @Override
    public void save(Order entity) {
        entity.setId(IdGenerator.generateOrderId());
        repository.add(entity);
    }
}
