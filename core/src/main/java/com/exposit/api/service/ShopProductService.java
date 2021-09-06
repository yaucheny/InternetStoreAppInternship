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
    /**
     * Returns ShopProduct by id.
     *
     * @param shopProductDto dto object of saving ShopProduct
     * @author Yauheni Markevich
     */
    void addShopProduct(ShopProductDto shopProductDto);

    /**
     * Deletes ShopProduct.
     *
     * @param id ShopProduct with id to delete
     * @throws com.exposit.utils.exceptions.ServiceException if ShopProduct was not found
     * @author Yauheni Markevich
     */
    void deleteShopProduct(Long id);

    /**
     * Updates ShopProduct.
     *
     * @param id             ShopProduct with id to update
     * @param shopProductDto dto object of searching ShopProduct
     * @throws com.exposit.utils.exceptions.ServiceException if ShopProduct was not found
     * @author Yauheni Markevich
     */
    void updateShopProduct(Long id, ShopProductDto shopProductDto);

    /**
     * Returns ShopProduct by id.
     *
     * @param id of searching ShopProduct
     * @return ShopProductDto.
     * @throws com.exposit.utils.exceptions.ServiceException if ShopProduct was not found
     * @author Yauheni Markevich
     */
    ShopProductDto getShopProductById(Long id);

    /**
     * Gets List of ShopProducts.
     *
     * @return List<ShopProductDto> of ShopProducts or emptyList
     * @author Yauheni Markevich
     */
    List<ShopProductDto> getAllShopProduct();

    /**
     * Saves ShopProducts to file.
     *
     * @author Yauheni Markevich
     */
    void saveShopProductToFile();

    /**
     * Sorts products in shop by price.
     *
     * @author Yauheni Markevich
     */
    List<ShopProductDto> sortByPrice();

    /**
     * Searches List of products with specific category.
     *
     * @param category category of product
     * @return List of products with specific category
     * @author Yauheni Markevich
     */
    List<ShopProductDto> getGoodsFromCategory(String category);

    /**
     * Searches products by two attributes.
     *
     * @param value1     value of field one of product
     * @param attribute1 name of field one product
     * @param value2     value of field two of product
     * @param attribute2 name of field two product
     * @return List of products searched by two specific fields.
     * @author Yauheni Markevich
     */
    List<ShopProductDto> findByTwoAttribute(String value1, String attribute1,
                                            String value2, String attribute2);

    /**
     * Searches products by one attribute.
     *
     * @param value     value of field of product
     * @param attribute name of field product
     * @return List of products searched by specific field.
     * @author Yauheni Markevich
     */
    List<ShopProductDto> findByOneAttribute(String value, String attribute);

    /**
     * Searches List of products with info about price and quantity.
     *
     * @param storeName name of store to get info abut price and quntity of products
     * @return info with price and quantity of products in store
     * @author Yauheni Markevich
     */
    List<PriceQuantityInStoreDto> infoAboutPriceQuantityInStore(String storeName);

    /**
     * Updates products in shop from csv file.
     *
     * @author Yauheni Markevich
     */
    void updateShopProductsFromCsv();

}
