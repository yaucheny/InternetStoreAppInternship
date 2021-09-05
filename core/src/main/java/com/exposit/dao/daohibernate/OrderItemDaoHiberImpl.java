package com.exposit.dao.daohibernate;

import com.exposit.api.dao.OrderItemDao;
import com.exposit.domain.model.db.OrderItemDb;
import com.exposit.domain.model.entity.OrderItemEntity;
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
 * Implementation of {@link OrderItemDao} interface.
 * Implementation works with Hibernate framework and postgres database
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public class OrderItemDaoHiberImpl implements OrderItemDao {

    private static final Logger LOG = LoggerFactory.getLogger(OrderItemDaoHiberImpl.class);
    private static final String GET_BY_ID_ERROR_LOG = "can not find an entity by id: {}";
    private static final String GET_BY_ID_ERROR_EXCEPTION = "can not find an entity by id: %s";

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    private ModelMapper mapper;

    @Override
    @Transactional
    public void save(OrderItemDb orderItemDb) {
        if (orderItemDb.getId() == null) {
            OrderItemEntity orderItemEntity = mapper.map(orderItemDb, OrderItemEntity.class);
            this.entityManager.persist(orderItemEntity);
        }
    }

    @Override
    @Transactional
    public void saveToFile(List<OrderItemDb> entity) {
        MarshallingJson.serializeJsonEntity(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public OrderItemDb getById(Long id) {
        try {
            OrderItemEntity orderItemEntity = this.entityManager.find(OrderItemEntity.class, id);
            return mapper.map(orderItemEntity, OrderItemDb.class);
        } catch (IllegalArgumentException e) {
            LOG.error(GET_BY_ID_ERROR_LOG, id);
            throw new NotFoundException(String.format(GET_BY_ID_ERROR_EXCEPTION, id), e);
        }
    }

    @Override
    @Transactional
    public void delete(OrderItemDb orderItemDb) {
        if (orderItemDb.getId() != null) {
            OrderItemEntity orderItemEntity = mapper.map(orderItemDb, OrderItemEntity.class);
            entityManager.remove(entityManager
                    .contains(orderItemEntity) ? orderItemEntity : entityManager.merge(orderItemEntity));
        }
    }

    @Override
    @Transactional
    public void update(Long id, OrderItemDb orderItemDb) {
        if (orderItemDb.getId() != null) {
            OrderItemEntity orderItemEntity = mapper.map(orderItemDb, OrderItemEntity.class);
            this.entityManager.merge(orderItemEntity);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderItemDb> getAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<OrderItemEntity> criteriaQuery = builder.createQuery(OrderItemEntity.class);
        Root<OrderItemEntity> entityRoot = criteriaQuery.from(OrderItemEntity.class);
        criteriaQuery.select(entityRoot);
        List<OrderItemEntity> orderItemEntityList = entityManager.createQuery(criteriaQuery).getResultList();

        Type listType = new TypeToken<List<OrderItemDb>>() {
        }.getType();
        return mapper.map(orderItemEntityList, listType);
    }

    @Autowired
    public void setMapper(ModelMapper mapper1) {
        this.mapper = mapper1;
    }
}
