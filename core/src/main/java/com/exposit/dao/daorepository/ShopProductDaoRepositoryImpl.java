package com.exposit.dao.daorepository;

import com.exposit.api.dao.ShopProductDao;
import com.exposit.dao.daorepository.repository.ShopProductRepository;
import com.exposit.domain.model.db.ShopProductDb;
import com.exposit.domain.model.entity.ShopProductEntity;
import com.exposit.utils.marshelling.MarshallingXml;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;
@Transactional
public class ShopProductDaoRepositoryImpl implements ShopProductDao {

    @Autowired
    private ShopProductRepository shopProductRepository;
    @Autowired
    private ModelMapper mapper;


    @Override
    public void save(ShopProductDb shopProductDb) {
        if (shopProductDb.getId() == null) {
            ShopProductEntity categoryEntity = mapper.map(shopProductDb, ShopProductEntity.class);
            shopProductRepository.save(categoryEntity);
        }
    }

    @Override
    public List<ShopProductDb> sortByPrice() {
        List<ShopProductEntity> categoryEntityList = shopProductRepository.findAll(Sort.by("price"));
        Type listType = new TypeToken<List<ShopProductDb>>() {
        }.getType();
        return mapper.map(categoryEntityList, listType);
    }

    @Override
    public void saveToFile(List<ShopProductDb> entity) {
        MarshallingXml.serializeJsonEntity(entity);
    }

    @Override
    public ShopProductDb getById(Long id) {
        ShopProductEntity shopProductEntity = shopProductRepository.getById(id);
        return mapper.map(shopProductEntity, ShopProductDb.class);
    }

    @Override
    public void delete(ShopProductDb shopProductDb) {
        if (shopProductDb.getId() != null) {
            ShopProductEntity categoryEntity = mapper.map(shopProductDb, ShopProductEntity.class);
            shopProductRepository.delete(categoryEntity);
        }
    }

    @Override
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
    public List<ShopProductDb> getAll() {
        List<ShopProductEntity> categoryEntityList = shopProductRepository.findAll();
        Type listType = new TypeToken<List<ShopProductDb>>() {
        }.getType();
        return mapper.map(categoryEntityList, listType);
    }
}

