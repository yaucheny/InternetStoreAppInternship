package com.exposit.dao.daorepository;

import com.exposit.api.dao.OrderItemDao;
import com.exposit.dao.daorepository.repository.OrderItemRepository;
import com.exposit.domain.model.db.OrderItemDb;
import com.exposit.domain.model.entity.OrderItemEntity;
import com.exposit.utils.marshelling.MarshallingXml;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;
@Transactional
public class OrderItemDaoRepositoryImpl implements OrderItemDao {

    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public void save(OrderItemDb orderItemDb) {
        if (orderItemDb.getId() == null) {
            OrderItemEntity categoryEntity = mapper.map(orderItemDb, OrderItemEntity.class);
            orderItemRepository.save(categoryEntity);
        }
    }

    @Override
    public void saveToFile(List<OrderItemDb> entity) {
        MarshallingXml.serializeJsonEntity(entity);
    }

    @Override
    public OrderItemDb getById(Long id) {
        OrderItemEntity orderItemEntity = orderItemRepository.getById(id);
        return mapper.map(orderItemEntity, OrderItemDb.class);
    }

    @Override
    public void delete(OrderItemDb orderItemDb) {
        if (orderItemDb.getId() != null) {
            OrderItemEntity categoryEntity = mapper.map(orderItemDb, OrderItemEntity.class);
            orderItemRepository.delete(categoryEntity);
        }
    }

    @Override
    public void update(Long id, OrderItemDb orderItemDb) {
        if (orderItemDb.getId() != null) {
            OrderItemEntity orderItemEntityToUpdate = orderItemRepository.getById(id);
            OrderItemEntity orderItemEntity = mapper.map(orderItemDb, OrderItemEntity.class);
            orderItemEntityToUpdate.setQuantity(orderItemEntity.getQuantity());
            orderItemEntityToUpdate.setShopProduct(orderItemEntity.getShopProduct());
            orderItemRepository.save(orderItemEntityToUpdate);
        }
    }

    @Override
    public List<OrderItemDb> getAll() {
        List<OrderItemEntity> orderItemEntityList = orderItemRepository.findAll();
        Type listType = new TypeToken<List<OrderItemDb>>() {
        }.getType();
        return mapper.map(orderItemEntityList, listType);
    }
}

