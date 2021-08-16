package com.exposit.dao.daohibernate;

import com.exposit.api.dao.ProductDao;
import com.exposit.domain.model.db.ProductDb;
import com.exposit.domain.model.entity.ProductEntity;
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

public class ProductDaoHiberImpl implements ProductDao {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    @Autowired
    private ModelMapper mapper;

    private List<ProductEntity> repository = new ArrayList<>();

    @Override
    public void save(ProductDb productDb) {
        if (productDb.getId() == null) {
            ProductEntity productEntity = mapper.map(productDb, ProductEntity.class);
            this.entityManager.persist(productEntity);
        }
    }

    @Override
    public void saveToFile(List<ProductDb> entity) {

    }

    public ProductDb getById(Long id) {
        ProductEntity productEntity = this.entityManager.find(ProductEntity.class, id);
        return mapper.map(productEntity, ProductDb.class);
    }

    @Override
    public void delete(ProductDb productDb) {
        if (productDb.getId() != null) {
            ProductEntity productEntity = mapper.map(productDb, ProductEntity.class);
            entityManager.remove(entityManager
                    .contains(productEntity) ? productEntity : entityManager.merge(productEntity));
        }
    }

    @Override
    public void update(Long id, ProductDb productDb) {
        if (productDb.getId() != null) {
            ProductEntity productEntity = mapper.map(productDb, ProductEntity.class);
            this.entityManager.merge(productEntity);
        }
    }

    @Override
    public List<ProductDb> getAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProductEntity> criteriaQuery = builder.createQuery(ProductEntity.class);
        Root<ProductEntity> entityRoot = criteriaQuery.from(ProductEntity.class);
        criteriaQuery.select(entityRoot);
        List<ProductEntity> productEntityList = entityManager.createQuery(criteriaQuery).getResultList();

        Type listType = new TypeToken<List<ProductDb>>() {
        }.getType();
        return mapper.map(productEntityList, listType);
    }
}
