package com.exposit.dao.daoxml;

import com.exposit.api.dao.ShopProductDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.xml.MarshallingShopProductXml;
import com.exposit.model.ShopProductEntity;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ShopProductDaoXmlImpl extends AbstractDaoXmlImpl<ShopProductEntity>
        implements ShopProductDao {

    private ShopProductDao shopProductDao;

    public ShopProductDaoXmlImpl() {
        List<ShopProductEntity> shopProduct = MarshallingShopProductXml
                .deSerializeShopProduct();
        for (ShopProductEntity entity : shopProduct) {
            this.autoLoad(entity);
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

    private void autoLoad(ShopProductEntity entity){
        repository.add(entity);
    }
}
