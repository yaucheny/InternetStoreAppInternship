package com.exposit.dao.daojson;

import com.exposit.api.dao.ProductDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.json.MarshallingProductJson;
import com.exposit.model.*;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public class ProductDaoJsonImpl extends AbstractDaoJsonImpl<ProductEntity>
        implements ProductDao {

    private static ProductDao instance;

    private ProductDaoJsonImpl() {
        List<ProductEntity> product = MarshallingProductJson
        .deSerializeProduct();
        for (ProductEntity entity : product) {
            this.save(entity);
        }
    }

    public static ProductDao getInstance() {
        if (instance == null) {
            instance = new ProductDaoJsonImpl();
        }
        return instance;
    }

    @Override
    public void save(ProductEntity entity) {
        entity.setId(IdGenerator.generateProductId());
        repository.add(entity);
    }
}
