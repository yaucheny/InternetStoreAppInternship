package com.exposit.dao.daojson;

import com.exposit.api.dao.ShopProductDao;
import com.exposit.domain.model.db.ShopProductDb;
import com.exposit.utils.idgenerators.IdGenerator;
import com.exposit.utils.marshelling.MarshallingJson;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ShopProductDaoJsonImpl extends AbstractDaoJsonImpl<ShopProductDb> implements ShopProductDao {

    private ShopProductDao shopProductDao;

    public ShopProductDaoJsonImpl() {
        List<ShopProductDb> shopProduct = MarshallingJson.deserializeJsonEntity(ShopProductDb.class);
        for (ShopProductDb entity : shopProduct) {
            this.autoLoad(entity);
        }
        IdGenerator.setShopProductId((long) shopProduct.size() + 1);
    }

    @Override
    public void save(ShopProductDb entity) {
        entity.setId(IdGenerator.generateShopProductId());
        repository.add(entity);
    }

    @Override
    public List<ShopProductDb> sortByPrice() {
        List<ShopProductDb> productList = shopProductDao.getAll();
        return productList.stream().sorted(Comparator.comparingDouble(ShopProductDb::getPrice))
                .collect(Collectors.toList());
    }
}
