package com.exposit.model;

import java.util.List;

public class ProductFromServer extends AEntity {
    private String productName;
    private String productProducer;
    private List<Category> categories;

    public ProductFromServer() {
    }

    public ProductFromServer(Long id, String productName, String productProducer, List<Category> categories) {
        super(id);
        this.productName = productName;
        this.productProducer = productProducer;
        this.categories = categories;
    }

    public ProductFromServer(String productName, String productProducer, List<Category> categories) {
        this.productName = productName;
        this.productProducer = productProducer;
        this.categories = categories;
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "ProductServer{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productProducer='" + productProducer + '\'' +
                ", categories=" + categories +
                '}';
    }
}
