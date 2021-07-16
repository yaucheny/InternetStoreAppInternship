package com.exposit.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer extends AEntity {

    private String firstName;
    private String lastName;
    private String customerAddress;
    private String customerEmail;
    @JsonCreator
    public Customer(@JsonProperty("id")Long id,
                    @JsonProperty("firstName")String firstName,
                    @JsonProperty("lastName")String lastName,
                    @JsonProperty("customerAddress") String customerAddress,
                    @JsonProperty("customerEmail")String customerEmail) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerAddress = customerAddress;
        this.customerEmail = customerEmail;
    }

    public Customer(String firstName, String lastName, String customerAddress, String customerEmail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerAddress = customerAddress;
        this.customerEmail = customerEmail;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", customerAdress='" + customerAddress + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                                '}';
    }
}
