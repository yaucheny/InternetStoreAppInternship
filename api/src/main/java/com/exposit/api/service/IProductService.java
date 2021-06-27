package com.exposit.api.service;

import com.exposit.model.*;
import com.exposit.model.utils.PriceQuantityInStore;

import java.util.List;

public interface IProductService {

    Product addProduct(String productName, String productProducer, Integer productPrice,
                       Integer productQuantity, Store store, CategoryOne categoryOne,
                       CategoryTwo categoryTwo, CategoryThree categoryThree);

    void deleteProduct(Long productId);

    void updateProduct(Long productId, String productName, String productProducer, Integer productPrice,
                       Integer productQuantity, Store store, CategoryOne categoryOne,
                       CategoryTwo categoryTwo, CategoryThree categoryThree);

    List<Product> findByTwoAttribute(String value1, String attribute1,
                                     String value2, String attribute2);

    List<Product> findByOneAttribute(String value, String attribute);

    List<PriceQuantityInStore> infoAboutPriceQuantityInStore(String storeName);

    List<Product> sortByPrice();

    List<Product> getProductFromCategory(String category);

    Product getProductById(Long goodsId);

    List<Product> getAllProducts();

    void saveProductToFile();
}
