package com.exposit.domain.model;

import com.exposit.domain.model.db.ProductDb;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Simple JavaBean object that represents a object constructed to represent a special fields of ShopProduct.class.
 *
 * @author Yauheni Markevich
 * @version 1.0
 * @see com.exposit.api.service.ShopProductService#infoAboutPriceQuantityInStore(String)
 */
@Data
@AllArgsConstructor
public class PriceQuantityInStore {

    private ProductDb productDb;
    private Double price;
    private Integer quantity;
    private String storeName;

    @Override
    public String toString() {
        return "PriceQuantityInStore{"
                + "product=" + productDb
                + "price=" + price
                + ", quantity=" + quantity
                + ", storeName='" + storeName + '\''
                + '}';
    }
}
