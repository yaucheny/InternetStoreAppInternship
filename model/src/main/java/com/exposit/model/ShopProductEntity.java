package com.exposit.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ShopProductEntity extends AEntity {

    private ProductEntity product;
    private Integer price;
    private Integer quantity;
    private StoreEntity store;
    private String description;

    @Override
    public String toString() {
        return "ShopProduct{"
                + "id=" + id
                + ", product=" + product
                + ", price=" + price
                + ", quantity=" + quantity
                + ", store=" + store
                + ", description='" + description + '\''
                + '}';
    }
}
