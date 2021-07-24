package com.exposit.dao.daoxml;

import com.exposit.api.dao.ShopProductDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.xml.MarshallingShopProductXml;
import com.exposit.model.ShopProductEntity;
import org.springframework.stereotype.Repository;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ShopProductDaoXmlImpl extends AbstractDaoXmlImpl<ShopProductEntity>
        implements ShopProductDao {

    private static ShopProductDao instance;

    private ShopProductDaoXmlImpl() {
        List<ShopProductEntity> product = MarshallingShopProductXml
                .deSerializeShopProduct();
        for (ShopProductEntity entity : product) {
            this.save(entity);
        }
    }

    public static ShopProductDao getInstance() {
        if (instance == null) {
            instance = new ShopProductDaoXmlImpl();
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
