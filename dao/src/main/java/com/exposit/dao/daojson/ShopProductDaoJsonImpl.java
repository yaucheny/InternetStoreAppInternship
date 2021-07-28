package com.exposit.dao.daojson;

import com.exposit.api.dao.ShopProductDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.json.MarshallingShopProductJson;
import com.exposit.model.ShopProductEntity;
import org.springframework.stereotype.Repository;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository("shopProductDaoJson")
public class ShopProductDaoJsonImpl extends AbstractDaoJsonImpl<ShopProductEntity>
        implements ShopProductDao {

    private ShopProductDao shopProductDao;

    private ShopProductDaoJsonImpl() {
        List<ShopProductEntity> product = MarshallingShopProductJson
                .deSerializeShopProduct();
        for (ShopProductEntity entity : product) {
            this.save(entity);
        }
    }

    @Override
    public void save(ShopProductEntity entity) {
        entity.setId(IdGenerator.generateShopProductId());
        repository.add(entity);
    }

    @Override
    public List<ShopProductEntity> sortByPrice() {
        List<ShopProductEntity> productList = shopProductDao.getAll();
        return productList.stream().sorted(Comparator
                .comparingInt(ShopProductEntity::getPrice))
                .collect(Collectors.toList());
    }
}
