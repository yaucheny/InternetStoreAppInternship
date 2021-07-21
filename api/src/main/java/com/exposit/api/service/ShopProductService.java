package com.exposit.api.service;

import com.exposit.model.ProductEntity;
import com.exposit.model.ShopProductEntity;
import com.exposit.model.StoreEntity;
import com.exposit.model.utils.PriceQuantityInStore;

import java.util.List;

public interface ShopProductService {


    ShopProductEntity addShopProduct(ProductEntity product, Integer price,
                                     Integer quantity, StoreEntity store, String description);

    void deleteShopProduct(Long id);

    void updateShopProduct(Long id, ProductEntity product, Integer price,
                           Integer quantity, StoreEntity store, String description);

    ShopProductEntity getShopProductById(Long id);

    List<ShopProductEntity> getAllShopProduct();

    void saveShopProductToFile();

    List<ShopProductEntity> sortByPrice();

    List<ShopProductEntity> getGoodsFromCategory(String category);

    List<ShopProductEntity> findByTwoAttribute(String value1, String attribute1,
                                               String value2, String attribute2);

    List<ShopProductEntity> findByOneAttribute(String value, String attribute);

    List<PriceQuantityInStore> infoAboutPriceQuantityInStore(String storeName);

}
