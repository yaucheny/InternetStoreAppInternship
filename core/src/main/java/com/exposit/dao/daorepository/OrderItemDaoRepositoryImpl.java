package com.exposit.dao.daorepository;

import com.exposit.api.dao.OrderItemDao;
import com.exposit.dao.daorepository.repository.OrderItemRepository;
import com.exposit.domain.model.db.OrderItemDb;
import com.exposit.domain.model.entity.OrderItemEntity;
import com.exposit.utils.exceptions.NotFoundException;
import com.exposit.utils.marshelling.MarshallingXml;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;

public class OrderItemDaoRepositoryImpl implements OrderItemDao {

    private static final Logger LOG = LoggerFactory.getLogger(OrderItemDaoRepositoryImpl.class);
    private static final String GET_BY_ID_ERROR_LOG = "can not find an entity by id: {}";
    private static final String GET_BY_ID_ERROR_EXCEPTION = "can not find an entity by id: %s";

    private OrderItemRepository orderItemRepository;
    private ModelMapper mapper;

    @Override
    @Transactional
    public void save(OrderItemDb orderItemDb) {
        if (orderItemDb.getId() == null) {
            OrderItemEntity categoryEntity = mapper.map(orderItemDb, OrderItemEntity.class);
            orderItemRepository.save(categoryEntity);
        }
    }

    @Override
    @Transactional
    public void saveToFile(List<OrderItemDb> entity) {
        MarshallingXml.serializeJsonEntity(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public OrderItemDb getById(Long id) {
        try {
            OrderItemEntity orderItemEntity = orderItemRepository.getById(id);
            return mapper.map(orderItemEntity, OrderItemDb.class);
        } catch (Exception e) {
            LOG.error(GET_BY_ID_ERROR_LOG, id);
            throw new NotFoundException(String.format(GET_BY_ID_ERROR_EXCEPTION, id));
        }
    }

    @Override
    @Transactional
    public void delete(OrderItemDb orderItemDb) {
        if (orderItemDb.getId() != null) {
            OrderItemEntity categoryEntity = mapper.map(orderItemDb, OrderItemEntity.class);
            orderItemRepository.delete(categoryEntity);
        }
    }

    @Override
    @Transactional
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
    @Transactional(readOnly = true)
    public List<OrderItemDb> getAll() {
        List<OrderItemEntity> orderItemEntityList = orderItemRepository.findAll();
        Type listType = new TypeToken<List<OrderItemDb>>() {
        }.getType();
        return mapper.map(orderItemEntityList, listType);
    }

    @Autowired
    public void setMapper(ModelMapper mapper1) {
        this.mapper = mapper1;
    }

    @Autowired

    public void setOrderItemRepository(OrderItemRepository orderItemRepository1) {
        this.orderItemRepository = orderItemRepository1;
    }
}

