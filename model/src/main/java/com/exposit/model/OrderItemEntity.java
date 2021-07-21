package com.exposit.model;


import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemEntity extends AEntity {

    private ShopProductEntity shopProduct;
    private Integer quantity;

    public OrderItemEntity(Long id, ShopProductEntity shopProduct, Integer quantity) {
        super(id);
        this.shopProduct = shopProduct;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{"
                + "id=" + id
                + ", shopProduct=" + shopProduct
                + ", quantity=" + quantity
                + '}';
    }
}
