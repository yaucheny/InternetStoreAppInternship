package com.exposit.dao.daojson;

import com.exposit.api.dao.ShopProductDao;
import com.exposit.utils.idgenerators.IdGenerator;
import com.exposit.utils.marshelling.json.MarshallingShopProductJson;
import com.exposit.domain.model.db.ShopProductDb;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ShopProductDaoJsonImpl extends AbstractDaoJsonImpl<ShopProductDb> implements ShopProductDao {

    private ShopProductDao shopProductDao;

    public ShopProductDaoJsonImpl() {
        List<ShopProductDb> shopProduct = MarshallingShopProductJson.deSerializeShopProduct();
        for (ShopProductDb entity : shopProduct) {
            this.autoLoad(entity);
        }
    }

    @Override
    public void save(ShopProductDb entity) {
        entity.setId(IdGenerator.generateShopProductId());
        repository.add(entity);
    }

    private void autoLoad(ShopProductDb entity) {
        repository.add(entity);
    }

    @Override
    public List<ShopProductDb> sortByPrice() {
        List<ShopProductDb> productList = shopProductDao.getAll();
        return productList.stream().sorted(Comparator.comparingDouble(ShopProductDb::getPrice))
                .collect(Collectors.toList());
    }

    @Override
    public void saveToFile(List<ShopProductDb> entity) {

    }
}
