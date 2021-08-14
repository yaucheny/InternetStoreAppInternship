package com.exposit.dao.daohibernate;

import com.exposit.api.dao.OrderItemDao;
import com.exposit.model.db.OrderItemDb;
import com.exposit.model.entity.OrderItemEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDaoHiberImpl implements OrderItemDao {


    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    @Autowired
    private ModelMapper mapper;

    private List<OrderItemEntity> repository = new ArrayList<>();

    @Override
    public void save(OrderItemDb orderItemDb) {
        if (orderItemDb.getId() == null) {
            OrderItemEntity orderItemEntity = mapper.map(orderItemDb, OrderItemEntity.class);
            this.entityManager.persist(orderItemEntity);
        }
    }

    @Override
    public void saveToFile(List<OrderItemDb> orderItemDbList) {

    }

    public OrderItemDb getById(Long id) {
        OrderItemEntity orderItemEntity = this.entityManager.find(OrderItemEntity.class, id);
        return mapper.map(orderItemEntity, OrderItemDb.class);
    }

    @Override
    public void delete(OrderItemDb orderItemDb) {
        if (orderItemDb.getId() != null) {
            OrderItemEntity orderItemEntity = mapper.map(orderItemDb, OrderItemEntity.class);
            entityManager.remove(entityManager
                    .contains(orderItemEntity) ? orderItemEntity : entityManager.merge(orderItemEntity));
        }
    }

    @Override
    public void update(Long id, OrderItemDb orderItemDb) {
        if (orderItemDb.getId() != null) {
            OrderItemEntity orderItemEntity = mapper.map(orderItemDb, OrderItemEntity.class);
            this.entityManager.merge(orderItemEntity);
        }
    }

    @Override
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
}
