package com.exposit.domain.model.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Simple JavaBean object that represents a OrderItem entity. This additional object is created
 * to work with hibernate and spring data JPA. This object is mapped from OrderItemdb object
 * {@link com.exposit.domain.model.db.OrderItemDb} in dao layer.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "items")
public class OrderItemEntity extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "product_shop_id")
    private ShopProductEntity shopProduct;

    @Column(name = "quantity")
    private Integer quantity;
}
