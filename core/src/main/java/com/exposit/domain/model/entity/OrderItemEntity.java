package com.exposit.domain.model.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
/**
 * Simple JavaBean object that represents a OrderItem entity. This additional object is created
 * to work with hibernate and spring data JPA. This object is mapped from OrderItemdb object
 * {@link com.exposit.domain.model.db.OrderItemDb} in dao layer.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "items")
public class OrderItemEntity extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
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
