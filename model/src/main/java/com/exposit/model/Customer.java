package com.exposit.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer extends AEntity {

    private String firstName;
    private String lastName;
    private String customerAdress;
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
        this.customerAdress = customerAddress;
        this.customerEmail = customerEmail;
    }

    public Customer(String firstName, String lastName, String customerAdress, String customerEmail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerAdress = customerAdress;
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

    public String getCustomerAdress() {
        return customerAdress;
    }

    public void setCustomerAdress(String customerAdress) {
        this.customerAdress = customerAdress;
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
                ", customerAdress='" + customerAdress + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                                '}';
    }
}
