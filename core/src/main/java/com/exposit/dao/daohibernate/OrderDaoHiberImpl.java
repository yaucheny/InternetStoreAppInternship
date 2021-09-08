package com.exposit.dao.daohibernate;

import com.exposit.api.dao.OrderDao;
import com.exposit.domain.model.db.OrderDb;
import com.exposit.domain.model.entity.OrderEntity;
import com.exposit.utils.exceptions.NotFoundException;
import com.exposit.utils.marshelling.MarshallingJson;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Implementation of {@link OrderDao} interface.
 * Implementation works with Hibernate framework and postgres database
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public class OrderDaoHiberImpl implements OrderDao {

    private static final Logger LOG = LoggerFactory.getLogger(OrderDaoHiberImpl.class);
    private static final String GET_BY_ID_ERROR_LOG = "can not find an entity by id: {}";
    private static final String GET_BY_ID_ERROR_EXCEPTION = "can not find an entity by id: %s";

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    private ModelMapper mapper;

    @Override
    @Transactional
    public void save(OrderDb orderDb) {
        if (orderDb.getId() == null) {
            OrderEntity orderEntity = mapper.map(orderDb, OrderEntity.class);
            this.entityManager.persist(orderEntity);
        }
    }

    @Override
    @Transactional
    public void saveToFile(List<OrderDb> entity) {
        MarshallingJson.serializeJsonEntity(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public OrderDb getById(Long id) {
        try {
            OrderEntity orderEntity = this.entityManager.find(OrderEntity.class, id);
            return mapper.map(orderEntity, OrderDb.class);
        } catch (IllegalArgumentException e) {
            LOG.error(GET_BY_ID_ERROR_LOG, id);
            throw new NotFoundException(String.format(GET_BY_ID_ERROR_EXCEPTION, id), e);
        }
    }

    @Override
    @Transactional
    public void delete(OrderDb orderDb) {
        if (orderDb.getId() != null) {
            OrderEntity orderEntity = mapper.map(orderDb, OrderEntity.class);
            entityManager.remove(entityManager
                    .contains(orderEntity) ? orderEntity : entityManager.merge(orderEntity));
        }
    }

    @Override
    @Transactional
    public void update(Long id, OrderDb orderDb) {
        if (this.getById(id) != null) {
            OrderEntity orderEntity = mapper.map(orderDb, OrderEntity.class);
            this.entityManager.merge(orderEntity);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderDb> getAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<OrderEntity> criteriaQuery = builder.createQuery(OrderEntity.class);
        Root<OrderEntity> entityRoot = criteriaQuery.from(OrderEntity.class);
        criteriaQuery.select(entityRoot);
        List<OrderEntity> orderEntityList = entityManager.createQuery(criteriaQuery).getResultList();

        Type listType = new TypeToken<List<OrderDb>>() {
        }.getType();
        return mapper.map(orderEntityList, listType);
    }

    @Autowired
    public void setMapper(ModelMapper mapper1) {
        this.mapper = mapper1;
    }
}
