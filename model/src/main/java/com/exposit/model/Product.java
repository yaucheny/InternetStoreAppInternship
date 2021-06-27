package com.exposit.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Product extends AEntity {

    private String productName;
    private String productProducer;
    private Integer productPrice;
    private Integer productQuantity;
    private Store store;
    private CategoryOne categoryOne;
    private CategoryTwo categoryTwo;
    private CategoryThree categoryThree;

    public Product(String productName, String productProducer, Integer productPrice,
                   Integer productQuantity, Store store, CategoryOne categoryOne,
                   CategoryTwo categoryTwo, CategoryThree categoryThree) {
        this.productName = productName;
        this.productProducer = productProducer;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.store = store;
        this.categoryOne = categoryOne;
        this.categoryTwo = categoryTwo;
        this.categoryThree = categoryThree;
    }

    @JsonCreator
    public Product(@JsonProperty("id") Long id,
                   @JsonProperty("productName") String productName,
                   @JsonProperty("productProducer") String productProducer,
                   @JsonProperty("productPrice") Integer productPrice,
                   @JsonProperty("productQuantity") Integer productQuantity,
                   @JsonProperty("store") Store store,
                   @JsonProperty("categoryOne") CategoryOne categoryOne,
                   @JsonProperty("categoryTwo") CategoryTwo categoryTwo,
                   @JsonProperty("categoryThree") CategoryThree categoryThree) {
        super(id);
        this.productName = productName;
        this.productProducer = productProducer;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.store = store;
        this.categoryOne = categoryOne;
        this.categoryTwo = categoryTwo;
        this.categoryThree = categoryThree;
    }

    public Product(Long id) {
        super(id);
    }

    public Product() {

    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductProducer() {
        return productProducer;
    }

    public void setProductProducer(String productProducer) {
        this.productProducer = productProducer;
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

    public CategoryOne getCategoryOne() {
        return categoryOne;
    }

    public void setCategoryOne(CategoryOne categoryOne) {
        this.categoryOne = categoryOne;
    }

    public CategoryTwo getCategoryTwo() {
        return categoryTwo;
    }

    public void setCategoryTwo(CategoryTwo categoryTwo) {
        this.categoryTwo = categoryTwo;
    }

    public CategoryThree getCategoryThree() {
        return categoryThree;
    }

    public void setCategoryThree(CategoryThree categoryThree) {
        this.categoryThree = categoryThree;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productProducer='" + productProducer + '\'' +
                ", productPrice=" + productPrice + '\'' +
                ", productQuantity=" + productQuantity + '\'' +
                ", store=" + store + '\'' +
                ", categoryOne=" + categoryOne + '\'' +
                ", categoryTwo=" + categoryTwo + '\'' +
                ", categoryThree=" + categoryThree + '\'' +
                '}';
    }
}
