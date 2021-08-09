package com.exposit.model.db;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
//@Entity
//@Table(name = "items")
public class OrderItemDb extends BaseDb {
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_shop_id")
    private ShopProductDb shopProduct;
//    @Column(name = "quantity")
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
