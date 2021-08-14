package com.exposit.model.entity;

import com.exposit.model.OrderStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity {

    @Column(name = "order_date")
    private LocalDate dateOfOrder;

    @Column(name = "delivery_date")
    private LocalDate dateOfDelivery;

    @Column(name = "purchase_price")
    private Integer priceOfPurchase;

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


    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "customer_id")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Override
    public String toString() {
        return "Order{"
                + "id=" + id
                + ", dateOfOrder=" + dateOfOrder
                + ", dateOfDelivery=" + dateOfDelivery
                + ", priceOfPurchase=" + priceOfPurchase
                + ", customer=" + customer
                + ", orderItemList=" + orderItemList
                + '}';
    }
}
