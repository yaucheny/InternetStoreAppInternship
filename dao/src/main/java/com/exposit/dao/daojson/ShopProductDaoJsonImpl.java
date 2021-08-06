package com.exposit.dao.daojson;

import com.exposit.api.dao.ShopProductDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.model.ShopProductEntity;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ShopProductDaoJsonImpl extends AbstractDaoJsonImpl<ShopProductEntity> implements ShopProductDao {

    private ShopProductDao shopProductDao;

    public ShopProductDaoJsonImpl() {
//        List<ShopProductEntity> shopProduct = MarshallingShopProductJson.deSerializeShopProduct();
//        for (ShopProductEntity entity : shopProduct) {
//            this.autoLoad(entity);
//        }
    }

    @Override
    public void save(ShopProductEntity entity) {
        entity.setId(IdGenerator.generateShopProductId());
        repository.add(entity);
    }

    private void autoLoad(ShopProductEntity entity) {
        repository.add(entity);
    }

    @Override
    public List<ShopProductEntity> sortByPrice() {
        List<ShopProductEntity> productList = shopProductDao.getAll();
        return productList.stream().sorted(Comparator.comparingInt(ShopProductEntity::getPrice))
                .collect(Collectors.toList());
    }
}
