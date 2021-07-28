package com.exposit.dao.daoxml;

import com.exposit.api.dao.ShopProductDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.xml.MarshallingCategoryXml;
import com.exposit.marshelling.xml.MarshallingShopProductXml;
import com.exposit.model.CategoryEntity;
import com.exposit.model.ShopProductEntity;
import org.springframework.stereotype.Repository;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository("shopXml")
public class ShopProductDaoXmlImpl extends AbstractDaoXmlImpl<ShopProductEntity>
        implements ShopProductDao {

    private ShopProductDao shopProductDao;

    public ShopProductDaoXmlImpl() {
        List<ShopProductEntity> category = MarshallingShopProductXml
                .deSerializeShopProduct();
        for (ShopProductEntity entity : category) {
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
