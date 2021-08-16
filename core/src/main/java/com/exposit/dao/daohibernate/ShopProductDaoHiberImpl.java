package com.exposit.dao.daohibernate;

import com.exposit.api.dao.ShopProductDao;
import com.exposit.domain.model.db.ShopProductDb;
import com.exposit.domain.model.entity.ShopProductEntity;
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

public class ShopProductDaoHiberImpl implements ShopProductDao {


    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    @Autowired
    private ModelMapper mapper;

    private List<ShopProductEntity> repository = new ArrayList<>();

    @Override
    public void save(ShopProductDb shopProductDb) {
        if (shopProductDb.getId() == null) {
            ShopProductEntity customerEntity = mapper.map(shopProductDb, ShopProductEntity.class);
            this.entityManager.persist(customerEntity);
        }
    }

    @Override
    public List<ShopProductDb> sortByPrice() {
        return null;
    }

    @Override
    public void saveToFile(List<ShopProductDb> shopProductDbList) {

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
