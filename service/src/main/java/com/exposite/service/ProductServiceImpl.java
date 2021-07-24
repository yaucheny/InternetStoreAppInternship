package com.exposite.service;

import com.exposit.api.dao.ProductDao;
import com.exposit.api.service.ProductService;
import com.exposit.dao.util.DaoPropertiesHandler;
import com.exposit.dao.util.ProductDaoFactory;
import com.exposit.exceptions.DaoException;
import com.exposit.exceptions.ServiceException;
import com.exposit.marshelling.json.MarshallingProductJson;
import com.exposit.model.*;
import com.exposit.model.CategoryEntity;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
public class ProductServiceImpl implements ProductService {

    private static final String PROPERTY;

    static {
        PROPERTY = DaoPropertiesHandler
                .getProperty("dao.serialization.config_dao_impl")
                .orElseThrow(() -> new ServiceException("Serialization path not found"));
    }

    private final ProductDao productDao;
    private static ProductServiceImpl instance;
    private static final String CAN_NOT_DELETE_PRODUCT
            = "can not delete product";
    private static final String CAN_NOT_UPDATE_PRODUCT
            = "can not update product";


    private ProductServiceImpl() {
        productDao = ProductDaoFactory.getProductDaoFromProperties(PROPERTY);
    }

    public static ProductServiceImpl getInstance() {
        if (instance == null) {
            instance = new ProductServiceImpl();
        }
        return instance;
    }

    @Override
    public ProductEntity addProduct(String name, String producer, List<CategoryEntity> categoryList) {
        ProductEntity product = new ProductEntity(name, producer, categoryList);
        productDao.save(product);
        return product;
    }

    @Override
    public void deleteProduct(Long id) {
        try {
            productDao.delete(productDao.getById(id));
        } catch (DaoException e) {
            log.warn(CAN_NOT_DELETE_PRODUCT, e);
            throw new ServiceException(CAN_NOT_DELETE_PRODUCT, e);
        }
    }

    @Override
    public void updateProduct(Long id, String name, String producer,
                              List<CategoryEntity> categoryList) {
        if (productDao.getById(id) != null) {
            ProductEntity product = new ProductEntity(name, producer,
                    categoryList);
            product.setId(id);
            productDao.update(id, product);
        } else {
            log.warn(CAN_NOT_UPDATE_PRODUCT);
            throw new ServiceException(CAN_NOT_UPDATE_PRODUCT);
        }
    }

    @Override
    public ProductEntity getProductById(Long id) {
        return productDao.getById(id);
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        return productDao.getAll();
    }

    @Override
    public void saveProductToFile() {
        MarshallingProductJson
                .serializeProduct(productDao.getAll());
    }


}
