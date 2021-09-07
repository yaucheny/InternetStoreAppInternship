package com.exposit.domain.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;
/**
 * Simple JavaBean object that represents a Order entity. This additional object is created
 * to work with hibernate and spring data JPA. This object is mapped from Vdb object
 * {@link com.exposit.domain.model.db.OrderDb} in dao layer.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity {

    @Column(name = "order_date")
    private LocalDate dateOfOrder;

    @Column(name = "delivery_date")
    private LocalDate dateOfDelivery;

    @Column(name = "purchase_price")
    private Double priceOfPurchase;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "orders_items", joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<OrderItemEntity> orderItemList;

    @Column(name = "delivery_term")
    private Long days;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatusEntity orderStatusEntity;
}
