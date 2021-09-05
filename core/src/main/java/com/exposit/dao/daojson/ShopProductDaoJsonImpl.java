package com.exposit.dao.daojson;

import com.exposit.api.dao.ShopProductDao;
import com.exposit.domain.model.db.ShopProductDb;
import com.exposit.utils.idgenerators.IdGenerator;
import com.exposit.utils.marshelling.MarshallingJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
/**
 * Implementation of {@link ShopProductDao} interface.
 * Implementation works with Jackson API and json format files
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public class ShopProductDaoJsonImpl extends AbstractDaoJsonImpl<ShopProductDb> implements ShopProductDao {

    private static final Logger LOG = LoggerFactory.getLogger(ShopProductDaoJsonImpl.class);

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
        LOG.debug("Execution of dao method sortBy price");
        List<ShopProductDb> productList = this.getAll();
        return productList.stream().sorted(Comparator.comparingDouble(ShopProductDb::getPrice))
                .collect(Collectors.toList());
    }
}
