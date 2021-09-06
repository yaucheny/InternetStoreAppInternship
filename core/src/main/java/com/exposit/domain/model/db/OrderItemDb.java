package com.exposit.domain.model.db;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * Simple JavaBean object that represents a OrderItem.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class OrderItemDb extends BaseDb {

    private ShopProductDb shopProduct;
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
