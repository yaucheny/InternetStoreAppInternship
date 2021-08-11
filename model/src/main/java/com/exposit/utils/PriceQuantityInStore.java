package com.exposit.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PriceQuantityInStore {
    private Double price;
    private Integer quantity;
    private String storeName;

    @Override
    public String toString() {
        return "PriceQuantityInStore{"
                + "price=" + price
                + ", quantity=" + quantity
                + ", storeName='" + storeName + '\''
                + '}';
    }
}
