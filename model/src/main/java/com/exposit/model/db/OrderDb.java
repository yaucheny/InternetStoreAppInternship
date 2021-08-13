package com.exposit.model.db;

import com.exposit.model.api.OrderModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
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
public class OrderDb extends BaseDb implements OrderModel {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @Column(name = "order_date")
    private LocalDate dateOfOrder;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @Column(name = "delivery_date")
    private LocalDate dateOfDelivery;

    @Column(name = "purchase_price")
    private Double priceOfPurchase;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerDb customer;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "orders_items", joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<OrderItemDb> orderItemList;

    @Column(name = "delivery_term")
    private Long days;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private OrderStatusDb orderStatusDb;

    @Override
    public String toString() {
        return "Order{"
                + "id=" + id
                + ", dateOfOrder=" + dateOfOrder
                + ", dateOfDelivery=" + dateOfDelivery
                + ", priceOfPurchase=" + priceOfPurchase
                + ", customer=" + customer
                + ", orderItemList=" + orderItemList
                + ", orderStatus=" + orderStatusDb
                + '}';
    }
}
