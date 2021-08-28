package com.exposit.domain.model;

import com.exposit.domain.model.db.ProductDb;
import lombok.AllArgsConstructor;
import lombok.Data;

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
