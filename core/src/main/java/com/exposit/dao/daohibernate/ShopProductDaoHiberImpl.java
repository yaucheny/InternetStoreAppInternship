package com.exposit.dao.daohibernate;

import com.exposit.api.dao.ShopProductDao;
import com.exposit.domain.model.db.ShopProductDb;
import com.exposit.domain.model.entity.ShopProductEntity;
import com.exposit.utils.marshelling.MarshallingJson;
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
public class ShopProductDaoHiberImpl implements ShopProductDao {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;
    private List<ShopProductEntity> repository = new ArrayList<>();

    @Autowired
    private ModelMapper mapper;

    @Override
    public void save(ShopProductDb shopProductDb) {
        if (shopProductDb.getId() == null) {
            ShopProductEntity customerEntity = mapper.map(shopProductDb, ShopProductEntity.class);
            this.entityManager.persist(customerEntity);
        }
    }

    @Override
    public List<ShopProductDb> sortByPrice() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ShopProductEntity> query = builder.createQuery(ShopProductEntity.class);
        Root<ShopProductEntity> root = query.from(ShopProductEntity.class);

        query.orderBy(builder.asc(root.get("price")));
        List<ShopProductEntity> shopProductEntityList = entityManager.createQuery(query).getResultList();
        Type listType = new TypeToken<List<ShopProductDb>>() {
        }.getType();
        return mapper.map(shopProductEntityList, listType);
    }

    @Override
    public void saveToFile(List<ShopProductDb> entity) {
        MarshallingJson.serializeJsonEntity(entity);
    }

    public ShopProductDb getById(Long id) {
        ShopProductEntity shopProductEntity = this.entityManager.find(ShopProductEntity.class, id);
        return mapper.map(shopProductEntity, ShopProductDb.class);
    }

    @Override
    public void delete(ShopProductDb shopProductDb) {
        if (shopProductDb.getId() != null) {
            ShopProductEntity customerEntity = mapper.map(shopProductDb, ShopProductEntity.class);
            entityManager.remove(entityManager
                    .contains(customerEntity) ? customerEntity : entityManager.merge(customerEntity));
        }
    }

    @Override
    public void update(Long id, ShopProductDb shopProductDb) {
        if (shopProductDb.getId() != null) {
            ShopProductEntity shopProductEntity = mapper.map(shopProductDb, ShopProductEntity.class);
            this.entityManager.merge(shopProductEntity);
        }
    }

    @Override
    public List<ShopProductDb> getAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ShopProductEntity> criteriaQuery = builder.createQuery(ShopProductEntity.class);
        Root<ShopProductEntity> entityRoot = criteriaQuery.from(ShopProductEntity.class);
        criteriaQuery.select(entityRoot);
        List<ShopProductEntity> shopProductEntityList = entityManager.createQuery(criteriaQuery).getResultList();

        Type listType = new TypeToken<List<ShopProductDb>>() {
        }.getType();
        return mapper.map(shopProductEntityList, listType);
    }
}
