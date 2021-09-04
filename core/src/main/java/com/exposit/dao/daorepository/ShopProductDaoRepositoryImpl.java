package com.exposit.dao.daorepository;

import com.exposit.api.dao.ShopProductDao;
import com.exposit.dao.daorepository.repository.ShopProductRepository;
import com.exposit.domain.model.db.ShopProductDb;
import com.exposit.domain.model.entity.ShopProductEntity;
import com.exposit.utils.exceptions.NotFoundException;
import com.exposit.utils.marshelling.MarshallingXml;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;


public class ShopProductDaoRepositoryImpl implements ShopProductDao {

    private static final Logger LOG = LoggerFactory.getLogger(ShopProductDaoRepositoryImpl.class);
    private static final String GET_BY_ID_ERROR_LOG = "can not find an entity by id: {}";
    private static final String GET_BY_ID_ERROR_EXCEPTION = "can not find an entity by id: %s";

    private ShopProductRepository shopProductRepository;
    private ModelMapper mapper;


    @Override
    @Transactional
    public void save(ShopProductDb shopProductDb) {
        if (shopProductDb.getId() == null) {
            ShopProductEntity categoryEntity = mapper.map(shopProductDb, ShopProductEntity.class);
            shopProductRepository.save(categoryEntity);
        }
    }

    @Override
    @Transactional
    public List<ShopProductDb> sortByPrice() {
        LOG.debug("Execution of dao method sortBy price");
        List<ShopProductEntity> categoryEntityList = shopProductRepository.findAll(Sort.by("price"));
        Type listType = new TypeToken<List<ShopProductDb>>() {
        }.getType();
        return mapper.map(categoryEntityList, listType);
    }

    @Override
    @Transactional
    public void saveToFile(List<ShopProductDb> entity) {
        MarshallingXml.serializeJsonEntity(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public ShopProductDb getById(Long id) {
        try {
            ShopProductEntity shopProductEntity = shopProductRepository.getById(id);
            return mapper.map(shopProductEntity, ShopProductDb.class);
        } catch (Exception e) {
            LOG.error(GET_BY_ID_ERROR_LOG, id);
            throw new NotFoundException(String.format(GET_BY_ID_ERROR_EXCEPTION, id));
        }
    }

    @Override
    @Transactional
    public void delete(ShopProductDb shopProductDb) {
        if (shopProductDb.getId() != null) {
            ShopProductEntity categoryEntity = mapper.map(shopProductDb, ShopProductEntity.class);
            shopProductRepository.delete(categoryEntity);
        }
    }

    @Override
    @Transactional
    public void update(Long id, ShopProductDb shopProductDb) {
        if (shopProductDb.getId() != null) {
            ShopProductEntity shopProductEntityToUpdate = shopProductRepository.getById(id);
            ShopProductEntity shopProductEntity = mapper.map(shopProductDb, ShopProductEntity.class);
            shopProductEntityToUpdate.setDescription(shopProductEntity.getDescription());
            shopProductEntityToUpdate.setPrice(shopProductEntity.getPrice());
            shopProductEntityToUpdate.setProduct(shopProductEntity.getProduct());
            shopProductEntityToUpdate.setQuantity(shopProductEntity.getQuantity());
            shopProductEntityToUpdate.setStore(shopProductEntity.getStore());
            shopProductRepository.save(shopProductEntityToUpdate);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<ShopProductDb> getAll() {
        List<ShopProductEntity> categoryEntityList = shopProductRepository.findAll();
        Type listType = new TypeToken<List<ShopProductDb>>() {
        }.getType();
        return mapper.map(categoryEntityList, listType);
    }

    @Autowired
    public void setMapper(ModelMapper mapper1) {
        this.mapper = mapper1;
    }

    @Autowired
    public void setShopProductRepository(ShopProductRepository shopProductRepository1) {
        this.shopProductRepository = shopProductRepository1;
    }
}

