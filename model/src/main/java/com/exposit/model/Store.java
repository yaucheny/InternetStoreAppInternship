package com.exposit.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Store extends AEntity {

    private String storeName;
    private String internetPage;
    private String phoneNumber;


    public Store(String storeName, String internetPage, String phoneNumber) {
        this.storeName = storeName;
        this.internetPage = internetPage;
        this.phoneNumber = phoneNumber;
    }

    public Store() {
    }

    @JsonCreator
    public Store(@JsonProperty("id") Long id,
                 @JsonProperty("storeName") String storeName,
                 @JsonProperty("internetPage")String internetPage,
                 @JsonProperty("phoneNumber")String phoneNumber) {
        super(id);
        this.storeName = storeName;
        this.internetPage = internetPage;
        this.phoneNumber = phoneNumber;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getInternetPage() {
        return internetPage;
    }

    public void setInternetPage(String internetPage) {
        this.internetPage = internetPage;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", storeName='" + storeName + '\'' +
                ", internetPage='" + internetPage + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
