package com.exposit.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "items")
public class OrderItemEntity extends AEntity {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_shop_id")
    private ShopProductEntity shopProduct;
    @Column(name = "quantity")
    private Integer quantity;

    @Override
    public String toString() {
        return "OrderItem{"
                + "id=" + id
                + ", shopProduct=" + shopProduct
                + ", quantity=" + quantity
                + '}';
    }
}
