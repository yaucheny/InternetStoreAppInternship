package com.exposit.dao.daojson;

import com.exposit.api.dao.ProductDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.json.MarshallingProductJson;
import com.exposit.model.*;
import lombok.extern.log4j.Log4j;

import java.util.List;

@Log4j
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
