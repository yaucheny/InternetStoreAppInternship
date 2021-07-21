package com.exposit.dao.daoJson;

import com.exposit.api.dao.ShopProductDao;
import com.exposit.idGenerators.IdGenerator;
import com.exposit.marshelling.json.MarshallingShopProductJson;
import com.exposit.model.ShopProductEntity;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ShopProductDaoJsonImpl extends AbstractDaoJsonImpl<ShopProductEntity>
        implements ShopProductDao {

    private static ShopProductDao instance;

    private ShopProductDaoJsonImpl() {
        List<ShopProductEntity> product = MarshallingShopProductJson
                .deSerializeShopProduct();
        for (ShopProductEntity entity : product) {
//            entity.setId(IdGenerator.generateShopProductId());
            this.save(entity);
        }
    }

    public static ShopProductDao getInstance() {
        if (instance == null) {
            instance = new ShopProductDaoJsonImpl();
        }
        return instance;
    }

    @Override
    public void save(ShopProductEntity entity) {
        entity.setId(IdGenerator.generateShopProductId());
        repository.add(entity);
    }

    @Override
    public List<ShopProductEntity> sortByPrice() {
        List<ShopProductEntity> productList=instance.getAll();
        return productList.stream().sorted(Comparator
                .comparingInt(ShopProductEntity::getPrice))
                .collect(Collectors.toList());
    }
}
