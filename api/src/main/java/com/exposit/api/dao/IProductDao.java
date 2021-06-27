package com.exposit.api.dao;

import com.exposit.model.Product;
import com.exposit.model.utils.PriceQuantityInStore;

import java.util.List;

public interface IProductDao extends IGenericDao<Product> {

    void save(Product entity);

    List<Product> sortByPrice();

   List<PriceQuantityInStore> infoAboutPriceQuantityInStore(String storeName);

   List<Product> getGoodsFromCategory(String category);

   List<Product> findByOneAttribute(String value, String attribute);

   List<Product> findByTwoAttribute(String value1, String attribute1,
                                    String value2, String attribute2);
   }
