package com.exposit.service;

import com.exposit.api.dao.IProductDao;
import com.exposit.api.service.IProductService;
import com.exposit.dao.ProductDao;
import com.exposit.exceptions.DaoException;
import com.exposit.exceptions.ServiceException;
import com.exposit.marshelling.MarshallingJsonHandlerProduct;
import com.exposit.model.*;
import com.exposit.model.utils.PriceQuantityInStore;
import lombok.extern.log4j.Log4j;

import java.util.List;

@Log4j
public class ProductService implements IProductService {

    private final IProductDao productDao;
    private static ProductService instance;
    private static final String CAN_NOT_DELETE_PRODUCT = "can not delete product";
    private static final String CAN_NOT_UPDATE_PRODUCT = "can not update product";

    private ProductService() {
        productDao = ProductDao.getInstance();
    }

    public static ProductService getInstance() {
        if (instance == null) {
            instance = new ProductService();
        }
        return instance;
    }

    @Override
    public Product addProduct(String productName, String productProducer, Integer productPrice,
                              Integer productQuantity, Store store, CategoryOne categoryOne,
                              CategoryTwo categoryTwo, CategoryThree categoryThree) {
        Product product = new Product(productName, productProducer,productPrice,productQuantity,store,categoryOne,
                 categoryTwo, categoryThree);
        productDao.save(product);
        return product;
    }

    @Override
    public void deleteProduct(Long productId) {
        try {
            productDao.delete(productDao.getById(productId));
        } catch (DaoException e) {
            log.warn(CAN_NOT_DELETE_PRODUCT, e);
            throw new ServiceException(CAN_NOT_DELETE_PRODUCT, e);
        }
    }

    @Override
    public void updateProduct(Long productId, String productName, String productProducer,
                              Integer goodsPrice, Integer goodsQuantity, Store store, CategoryOne categoryOne,
                              CategoryTwo categoryTwo, CategoryThree categoryThree) {
        if (productDao.getById(productId) != null) {
            Product product = new Product(productName, productProducer,
                    goodsPrice, goodsQuantity, store, categoryOne,
                     categoryTwo, categoryThree);
            product.setId(productId);
            productDao.update(productId, product);
        } else {
            log.warn(CAN_NOT_UPDATE_PRODUCT);
            throw new ServiceException(CAN_NOT_UPDATE_PRODUCT);
        }
    }

    @Override
    public List<Product> findByTwoAttribute(String value1, String attribute1,
                                            String value2, String attribute2) {
        return productDao.findByTwoAttribute(value1, attribute1,value2, attribute2);
    }

    @Override
    public List<Product> findByOneAttribute(String value, String attribute) {
        return productDao.findByOneAttribute(value,attribute);
    }

    @Override
    public List<PriceQuantityInStore> infoAboutPriceQuantityInStore(String storeName) {
        return productDao.infoAboutPriceQuantityInStore(storeName);
    }

    @Override
    public List<Product> sortByPrice() {
        return productDao.sortByPrice();
    }

    @Override
    public List<Product> getProductFromCategory(String category) {
        return productDao.getGoodsFromCategory(category);
    }

    @Override
    public Product getProductById(Long goodsId) {
        return productDao.getById(goodsId);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.getAll();
    }

    @Override
    public void saveProductToFile() {
        MarshallingJsonHandlerProduct.serializeProduct(productDao.getAll());
    }
}
