package com.exposit.domain.model.db;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ShopProductDb extends BaseDb {

    private ProductDb product;
    private Double price;
    private Integer quantity;
    private StoreDb store;
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
