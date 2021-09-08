package com.exposit.dao.daojson;

import com.exposit.api.dao.CategoryDao;
import com.exposit.api.dao.ProductDao;
import com.exposit.domain.model.db.ProductDb;
import com.exposit.utils.idgenerators.IdGenerator;
import com.exposit.utils.marshelling.MarshallingJson;

import java.util.List;

/**
 * Implementation of {@link CategoryDao} interface.
 * Implementation works with Jackson API and json format files
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public class ProductDaoJsonImpl extends AbstractDaoJsonImpl<ProductDb> implements ProductDao {

    public ProductDaoJsonImpl() {
        List<ProductDb> product = MarshallingJson.deserializeJsonEntity(ProductDb.class);
        for (ProductDb entity : product) {
            this.autoLoad(entity);
        }
        IdGenerator.setProductId((long) product.size() + 1);
    }

    @Override
    public void save(ProductDb entity) {
        entity.setId(IdGenerator.generateProductId());
        repository.add(entity);
    }
}
