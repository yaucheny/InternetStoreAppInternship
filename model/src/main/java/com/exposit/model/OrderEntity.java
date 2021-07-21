package com.exposit.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class OrderEntity extends AEntity {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dateOfOrder;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dateOfDelivery;

    private Integer priceOfPurchase;
    private CustomerEntity customer;
    private List<OrderItemEntity> orderItemList;
    private Long days;

    public OrderEntity(LocalDate dateOfOrder, LocalDate dateOfDelivery, Integer priceOfPurchase,
                       CustomerEntity customer, List<OrderItemEntity> orderItemList) {
        this.dateOfOrder = dateOfOrder;
        this.dateOfDelivery = dateOfDelivery;
        this.priceOfPurchase = priceOfPurchase;
        this.customer = customer;
        this.orderItemList = orderItemList;
    }

    public OrderEntity(Long days, CustomerEntity customer, List<OrderItemEntity> orderItemList) {
        this.customer = customer;
        this.orderItemList = orderItemList;
        this.days = days;
    }


    public OrderEntity(Long id, LocalDate dateOfOrder, LocalDate dateOfDelivery,
                       Integer priceOfPurchase, CustomerEntity customer,
                       List<OrderItemEntity> orderItemList, Long days) {
        super(id);
        this.dateOfOrder = dateOfOrder;
        this.dateOfDelivery = dateOfDelivery;
        this.priceOfPurchase = priceOfPurchase;
        this.customer = customer;
        this.orderItemList = orderItemList;
        this.days = days;
    }

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
