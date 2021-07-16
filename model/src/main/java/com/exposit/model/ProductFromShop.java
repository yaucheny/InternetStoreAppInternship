package com.exposit.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductFromShop extends AEntity {

    private ProductFromServer productFromServer;
    private Integer productPrice;
    private Integer productQuantity;
    private Store store;
    private String description;



    public ProductFromShop(ProductFromServer productFromServer, Integer productPrice, Integer productQuantity, Store store, String description) {
        this.productFromServer = productFromServer;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.store = store;
        this.description = description;
    }

    @JsonCreator
    public ProductFromShop(@JsonProperty("id") Long id,
                           @JsonProperty("productFromServer") ProductFromServer productFromServer,
                           @JsonProperty("productPrice") Integer productPrice,
                           @JsonProperty("productQuantity") Integer productQuantity,
                           @JsonProperty("store") Store store,
                           @JsonProperty("description") String description) {
        super(id);
        this.productFromServer = productFromServer;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.store = store;
        this.description = description;
    }

    public ProductFromShop() {

    }

    public ProductFromServer getProductFromServer() {
        return productFromServer;
    }

    public void setProductFromServer(ProductFromServer productFromServer) {
        this.productFromServer = productFromServer;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProductFromShop{" +
                "id=" + id +
                ", productFromServer=" + productFromServer +
                ", productPrice=" + productPrice +
                ", productQuantity=" + productQuantity +
                ", store=" + store +
                ", description='" + description + '\'' +
                '}';
    }
}
