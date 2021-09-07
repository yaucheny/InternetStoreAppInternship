package com.exposit.domain.model.db;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * Simple JavaBean object that represents a OrderItem.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OrderItemDb extends BaseDb {

    private ShopProductDb shopProduct;
    private Integer quantity;

}
