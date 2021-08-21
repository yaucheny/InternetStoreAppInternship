package com.exposit.dao.daohibernate;

import com.exposit.api.dao.OrderDao;
import com.exposit.domain.model.db.OrderDb;
import com.exposit.domain.model.entity.OrderEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


@Transactional
public class OrderDaoHiberImpl implements OrderDao {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;
    private List<OrderEntity> repository = new ArrayList<>();

    @Autowired
    private ModelMapper mapper;

    @Override
    public void save(OrderDb orderDb) {
        if (orderDb.getId() == null) {
            OrderEntity orderEntity = mapper.map(orderDb, OrderEntity.class);
            this.entityManager.persist(orderEntity);
        }
    }

    @Override
    public void saveToFile(List<OrderDb> orderDb) {

    }

    public OrderDb getById(Long id) {
        OrderEntity orderEntity = this.entityManager.find(OrderEntity.class, id);
        return mapper.map(orderEntity, OrderDb.class);
    }

    @Override
    public void delete(OrderDb orderDb) {
        if (orderDb.getId() != null) {
            OrderEntity orderEntity = mapper.map(orderDb, OrderEntity.class);
            entityManager.remove(entityManager
                    .contains(orderEntity) ? orderEntity : entityManager.merge(orderEntity));
        }
    }

    @Override
    public void update(Long id, OrderDb orderDb) {
        if (orderDb.getId() != null) {
            OrderEntity orderEntity = mapper.map(orderDb, OrderEntity.class);
            this.entityManager.merge(orderEntity);
        }
    }

    @Override
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
}
