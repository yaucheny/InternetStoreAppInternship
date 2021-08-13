package com.exposit.dao.daoxml;

import com.exposit.api.dao.ShopProductDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.xml.MarshallingShopProductXml;
import com.exposit.model.db.ShopProductDb;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ShopProductDaoXmlImpl extends AbstractDaoXmlImpl<ShopProductDb> implements ShopProductDao {

    private ShopProductDao shopProductDao;

    public ShopProductDaoXmlImpl() {
        List<ShopProductDb> shopProduct = MarshallingShopProductXml.deSerializeShopProduct();
        for (ShopProductDb entity : shopProduct) {
            this.autoLoad(entity);
        }
    }

    @Override
    public void save(ShopProductDb entity) {
        entity.setId(IdGenerator.generateShopProductId());
        repository.add(entity);
    }

    @Override
    public List<ShopProductDb> sortByPrice() {
        List<ShopProductDb> productList = shopProductDao.getAll();
        return productList.stream().sorted(Comparator
                .comparingDouble(ShopProductDb::getPrice))
                .collect(Collectors.toList());
    }

    @Override
    public void saveToFile(List<ShopProductDb> entity) {

    }

    private void autoLoad(ShopProductDb entity) {
        repository.add(entity);
    }
}
