package com.exposit.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderItem extends AEntity {

    ProductFromShop productFromShop;
    Integer quantityInOrder;

    public OrderItem() {
    }

    public OrderItem(ProductFromShop productFromShop, Integer quantityInOrder) {
        this.productFromShop = productFromShop;
        this.quantityInOrder = quantityInOrder;
    }

    @JsonCreator
    public OrderItem(
        @JsonProperty("id") Long id,
        @JsonProperty("product") ProductFromShop productFromShop,
        @JsonProperty("quantityInOrder") Integer quantityInOrder)
        {
        super(id);
        this.productFromShop = productFromShop;
        this.quantityInOrder = quantityInOrder;
    }

    public ProductFromShop getProduct() {
        return productFromShop;
    }

    public void setProduct(ProductFromShop productFromShop) {
        this.productFromShop = productFromShop;
    }

    public Integer getQuantityInOrder() {
        return quantityInOrder;
    }

    public void setQuantityInOrder(Integer quantityInOrder) {
        this.quantityInOrder = quantityInOrder;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", product=" + productFromShop +
                ", quantityInOrder=" + quantityInOrder +
                '}';
    }
}
