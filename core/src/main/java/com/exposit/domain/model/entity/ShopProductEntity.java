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
 * Simple JavaBean object that represents a ShopProduct entity. This additional object is created
 * to work with hibernate and spring data JPA. This object is mapped from ShopProduct object
 * {@link com.exposit.domain.model.db.ShopProductDb} in dao layer.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "product_shops")
public class ShopProductEntity extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @Column(name = "price")
    private Double price;

    @Column(name = "quantity")
    private Integer quantity;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "store_id")
    private StoreEntity store;

    @Column(name = "description")
    private String description;
}
