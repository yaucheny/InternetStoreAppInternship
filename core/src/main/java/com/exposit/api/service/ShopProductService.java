package com.exposit.api.service;

import com.exposit.domain.dto.PriceQuantityInStoreDto;
import com.exposit.domain.dto.ShopProductDto;

import java.util.List;
/**
 * Service interface for{@link com/exposit/domain/model/db/ShopProductDb.java}.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
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

    List<PriceQuantityInStoreDto> infoAboutPriceQuantityInStore(String storeName);

    void updateShopProductsFromCsv();

}
