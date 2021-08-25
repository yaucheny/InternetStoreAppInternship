package com.exposit.dao.daorepository;

import com.exposit.api.dao.ProductDao;
import com.exposit.dao.daorepository.repository.ProductRepository;
import com.exposit.domain.model.db.ProductDb;
import com.exposit.domain.model.entity.ProductEntity;
import com.exposit.utils.marshelling.MarshallingXml;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;
@Transactional
public class ProductDaoRepositoryImpl implements ProductDao {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public void save(ProductDb productDb) {
        if (productDb.getId() == null) {
            ProductEntity categoryEntity = mapper.map(productDb, ProductEntity.class);
            productRepository.save(categoryEntity);
        }
    }

    @Override
    public void saveToFile(List<ProductDb> entity) {
        MarshallingXml.serializeJsonEntity(entity);
    }

    @Override
    public ProductDb getById(Long id) {
        ProductEntity productEntity = productRepository.getById(id);
        return mapper.map(productEntity, ProductDb.class);
    }

    @Override
    public void delete(ProductDb productDb) {
        if (productDb.getId() != null) {
            ProductEntity categoryEntity = mapper.map(productDb, ProductEntity.class);
            productRepository.delete(categoryEntity);
        }
    }

    @Override
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
    public List<ProductDb> getAll() {
        List<ProductEntity> categoryEntityList = productRepository.findAll();
        Type listType = new TypeToken<List<ProductDb>>() {
        }.getType();
        return mapper.map(categoryEntityList, listType);
    }
}

