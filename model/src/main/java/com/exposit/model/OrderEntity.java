package com.exposit.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
