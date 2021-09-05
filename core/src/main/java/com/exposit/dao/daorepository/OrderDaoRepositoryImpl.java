package com.exposit.dao.daorepository;

import com.exposit.api.dao.OrderDao;
import com.exposit.dao.daorepository.repository.OrderRepository;
import com.exposit.domain.model.db.OrderDb;
import com.exposit.domain.model.entity.OrderEntity;
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
/**
 * Implementation of {@link OrderDao} interface.
 * Implementation works with spring data JPA and postgres database
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public class OrderDaoRepositoryImpl implements OrderDao {

    private static final Logger LOG = LoggerFactory.getLogger(OrderDaoRepositoryImpl.class);
    private static final String GET_BY_ID_ERROR_LOG = "can not find an entity by id: {}";
    private static final String GET_BY_ID_ERROR_EXCEPTION = "can not find an entity by id: %s";

    private OrderRepository orderRepository;
    private ModelMapper mapper;

    @Override
    @Transactional
    public void save(OrderDb orderDb) {
        if (orderDb.getId() == null) {
            OrderEntity categoryEntity = mapper.map(orderDb, OrderEntity.class);
            orderRepository.save(categoryEntity);
        }
    }

    @Override
    @Transactional
    public void saveToFile(List<OrderDb> entity) {
        MarshallingXml.serializeJsonEntity(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public OrderDb getById(Long id) {
        try {
            OrderEntity categoryEntity = orderRepository.getById(id);
            return mapper.map(categoryEntity, OrderDb.class);
        } catch (Exception e) {
            LOG.error(GET_BY_ID_ERROR_LOG, id);
            throw new NotFoundException(String.format(GET_BY_ID_ERROR_EXCEPTION, id));
        }
    }

    @Override
    @Transactional
    public void delete(OrderDb orderDb) {
        if (orderDb.getId() != null) {
            OrderEntity categoryEntity = mapper.map(orderDb, OrderEntity.class);
            orderRepository.delete(categoryEntity);
        }
    }

    @Override
    @Transactional
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
    @Transactional(readOnly = true)
    public List<OrderDb> getAll() {
        List<OrderEntity> categoryEntityList = orderRepository.findAll();
        Type listType = new TypeToken<List<OrderDb>>() {
        }.getType();
        return mapper.map(categoryEntityList, listType);
    }

    @Autowired
    public void setMapper(ModelMapper mapper1) {
        this.mapper = mapper1;
    }

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository1) {
        this.orderRepository = orderRepository1;
    }
}

