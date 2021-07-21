package com.exposit.model;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ShopProductEntity extends AEntity {

    private ProductEntity product;
    private Integer price;
    private Integer quantity;
    private StoreEntity store;
    private String description;

    public ShopProductEntity(Long id, ProductEntity product, Integer price,
                             Integer quantity, StoreEntity store, String description) {
        super(id);
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.store = store;
        this.description = description;
    }

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
