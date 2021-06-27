package com.exposit.model;

import com.exposit.model.utils.MyProductDeserializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;
import java.util.Map;

public class Order extends AEntity {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dateOfOrder;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dateOfDelivery;

    private Integer priceOfPurchase;
    private Customer customer;

    private Map<Product, Integer> mapOfGoods;
    private Long days;

    public Order(LocalDate dateOfOrder, LocalDate dateOfDelivery, Integer priceOfPurchase, Customer customer, Map<Product, Integer> mapOfGoods) {
        this.dateOfOrder = dateOfOrder;
        this.dateOfDelivery = dateOfDelivery;
        this.priceOfPurchase = priceOfPurchase;
        this.customer = customer;
        this.mapOfGoods = mapOfGoods;
    }

    public Order(Long days, Customer customer, Map<Product, Integer> mapOfGoods) {
        this.customer = customer;
        this.mapOfGoods = mapOfGoods;
        this.days = days;
    }

    @JsonCreator
    public Order(
            @JsonProperty("id")
                    Long id,
            @JsonProperty("dateOfOrder")
                    LocalDate dateOfOrder,
            @JsonProperty("dateOfDelivery")
                    LocalDate dateOfDelivery,
            @JsonProperty("priceOfPurchase")
                    Integer priceOfPurchase,
            @JsonProperty("customer")
                    Customer customer,
            @JsonDeserialize(keyUsing = MyProductDeserializer.class)
            @JsonProperty("mapOfGoods")
                    Map<Product, Integer> mapOfGoods,
            @JsonProperty("Long days")
                    Long days) {
        super(id);
        this.dateOfOrder = dateOfOrder;
        this.dateOfDelivery = dateOfDelivery;
        this.priceOfPurchase = priceOfPurchase;
        this.customer = customer;
        this.mapOfGoods = mapOfGoods;
        this.days = days;
    }

    public Order() {
    }

    public LocalDate getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(LocalDate dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public LocalDate getDateOfDelivery() {
        return dateOfDelivery;
    }

    public void setDateOfDelivery(LocalDate dateOfDelivery) {
        this.dateOfDelivery = dateOfDelivery;
    }

    public Integer getPriceOfPurchase() {
        return priceOfPurchase;
    }

    public void setPriceOfPurchase(Integer amountOfPurchase) {
        this.priceOfPurchase = amountOfPurchase;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Map<Product, Integer> getMapOfGoods() {
        return mapOfGoods;
    }

    public void setMapOfGoods(Map<Product, Integer> mapOfGoods) {
        this.mapOfGoods = mapOfGoods;
    }

    public Long getDays() {
        return days;
    }

    public void setDays(Long days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dateOfOrder=" + dateOfOrder +
                ", dateOfDelivery=" + dateOfDelivery +
                ", priceOfPurchase=" + priceOfPurchase +
                ", customer=" + customer +
                ", mapOfGoods=" + mapOfGoods +
                '}';
    }
}
