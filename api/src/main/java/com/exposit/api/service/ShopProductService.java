package com.exposit.api.service;

import com.exposit.dto.ShopProductDto;
import com.exposit.model.utils.PriceQuantityInStore;

import java.util.List;

public interface ShopProductService {

    void addShopProduct(ShopProductDto shopProductDto);

    void deleteShopProduct(Long id);

    void updateShopProduct(Long id, ShopProductDto shopProductDto);

    ShopProductDto getShopProductById(Long id);

    List<ShopProductDto> getAllShopProduct();

    void saveShopProductToFile();

    List<ShopProductDto> sortByPrice();

    List<ShopProductDto> getGoodsFromCategory(String category);

    List<ShopProductDto> findByTwoAttribute(String value1, String attribute1,
                                               String value2, String attribute2);

    List<ShopProductDto> findByOneAttribute(String value, String attribute);

    List<PriceQuantityInStore> infoAboutPriceQuantityInStore(String storeName);

}
