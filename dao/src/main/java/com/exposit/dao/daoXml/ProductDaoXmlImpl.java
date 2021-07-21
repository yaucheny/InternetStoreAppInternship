package com.exposit.dao.daoXml;

import com.exposit.api.dao.ProductDao;
import com.exposit.idGenerators.IdGenerator;
import com.exposit.marshelling.Xml.MarshallingProductXml;
import com.exposit.marshelling.json.MarshallingProductJson;
import com.exposit.model.ProductEntity;
import lombok.extern.log4j.Log4j;

import java.util.List;

@Log4j
public class ProductDaoXmlImpl extends AbstractDaoXmlImpl<ProductEntity>
        implements ProductDao {

    private static ProductDao instance;

    private ProductDaoXmlImpl() {
        List<ProductEntity> product = MarshallingProductXml
        .deSerializeProduct();
        for (ProductEntity entity : product) {
  //          entity.setId(IdGenerator.generateProductId());
            this.save(entity);
        }
    }

    public static ProductDao getInstance() {
        if (instance == null) {
            instance = new ProductDaoXmlImpl();
        }
        return instance;
    }

    @Override
    public void save(ProductEntity entity) {
        entity.setId(IdGenerator.generateProductId());
        repository.add(entity);
    }
}
