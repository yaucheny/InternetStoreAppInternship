package com.exposit.dao.daorepository;

import com.exposit.api.dao.ProductDao;
import com.exposit.dao.daorepository.repository.ProductRepository;
import com.exposit.domain.model.db.ProductDb;
import com.exposit.domain.model.entity.ProductEntity;
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
 * Implementation of {@link ProductDao} interface.
 * Implementation works with spring data JPA and postgres database
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public class ProductDaoRepositoryImpl implements ProductDao {

    private static final Logger LOG = LoggerFactory.getLogger(ProductDaoRepositoryImpl.class);
    private static final String GET_BY_ID_ERROR_LOG = "can not find an entity by id: {}";
    private static final String GET_BY_ID_ERROR_EXCEPTION = "can not find an entity by id: %s";

    private ProductRepository productRepository;
    private ModelMapper mapper;

    @Override
    @Transactional
    public void save(ProductDb productDb) {
        if (productDb.getId() == null) {
            ProductEntity categoryEntity = mapper.map(productDb, ProductEntity.class);
            productRepository.save(categoryEntity);
        }
    }

    @Override
    @Transactional
    public void saveToFile(List<ProductDb> entity) {
        MarshallingXml.serializeJsonEntity(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDb getById(Long id) {
        try {
            ProductEntity productEntity = productRepository.getById(id);
            return mapper.map(productEntity, ProductDb.class);
        } catch (Exception e) {
            LOG.error(GET_BY_ID_ERROR_LOG, id);
            throw new NotFoundException(String.format(GET_BY_ID_ERROR_EXCEPTION, id));
        }
    }

    @Override
    @Transactional
    public void delete(ProductDb productDb) {
        if (productDb.getId() != null) {
            ProductEntity categoryEntity = mapper.map(productDb, ProductEntity.class);
            productRepository.delete(categoryEntity);
        }
    }

    @Override
    @Transactional
    public void update(Long id, ProductDb productDb) {
        if (productDb.getId() != null) {
            ProductEntity productEntityToUpdate = productRepository.getById(id);
            ProductEntity productEntity = mapper.map(productDb, ProductEntity.class);
            productEntityToUpdate.setName(productEntity.getName());
            productEntityToUpdate.setProducer(productEntity.getProducer());
            productEntityToUpdate.setCategoryList(productEntity.getCategoryList());
            productRepository.save(productEntityToUpdate);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDb> getAll() {
        List<ProductEntity> categoryEntityList = productRepository.findAll();
        Type listType = new TypeToken<List<ProductDb>>() {
        }.getType();
        return mapper.map(categoryEntityList, listType);
    }

    @Autowired
    public void setMapper(ModelMapper mapper1) {
        this.mapper = mapper1;
    }

    @Autowired

    public void setProductRepository(ProductRepository productRepository1) {
        this.productRepository = productRepository1;
    }
}

