package com.exposit.dao.daorepository;

import com.exposit.api.dao.OrderDao;
import com.exposit.dao.daorepository.repository.OrderRepository;
import com.exposit.domain.model.db.OrderDb;
import com.exposit.domain.model.entity.OrderEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;
@Transactional
public class OrderDaoRepositoryImpl implements OrderDao {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ModelMapper mapper;


    @Override
    public void save(OrderDb orderDb) {
        if (orderDb.getId() == null) {
            OrderEntity categoryEntity = mapper.map(orderDb, OrderEntity.class);
            orderRepository.save(categoryEntity);
        }
    }

    @Override
    public void saveToFile(List<OrderDb> orderDbList) {

    }

    @Override
    public OrderDb getById(Long id) {
        OrderEntity categoryEntity = orderRepository.getById(id);
        return mapper.map(categoryEntity, OrderDb.class);
    }

    @Override
    public void delete(OrderDb orderDb) {
        if (orderDb.getId() != null) {
            OrderEntity categoryEntity = mapper.map(orderDb, OrderEntity.class);
            orderRepository.delete(categoryEntity);
        }
    }

    @Override
    public void update(Long id, OrderDb orderDb) {
        if (orderDb.getId() != null) {
            OrderEntity orderEntityToUpdate = orderRepository.getById(id);
            OrderEntity orderEntity = mapper.map(orderDb, OrderEntity.class);
            orderEntityToUpdate.setCustomer(orderEntity.getCustomer());
            orderEntityToUpdate.setDateOfDelivery(orderEntity.getDateOfDelivery());
            orderEntityToUpdate.setDateOfOrder(orderEntity.getDateOfOrder());
            orderEntityToUpdate.setDays(orderEntity.getDays());
            orderEntityToUpdate.setOrderItemList(orderEntity.getOrderItemList());
            orderEntityToUpdate.setOrderStatusEntity(orderEntity.getOrderStatusEntity());
            orderEntityToUpdate.setPriceOfPurchase(orderEntity.getPriceOfPurchase());
            orderRepository.save(orderEntityToUpdate);
        }
    }

    @Override
    public List<OrderDb> getAll() {
        List<OrderEntity> categoryEntityList = orderRepository.findAll();
        Type listType = new TypeToken<List<OrderDb>>() {
        }.getType();
        return mapper.map(categoryEntityList, listType);
    }
}

