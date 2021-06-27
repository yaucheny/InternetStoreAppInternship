package com.exposit.api.service;

import com.exposit.model.Customer;

import java.util.List;

public interface ICustomerService {

    Customer addCustomer(String firstName, String lastName, String customerAdress, String customerEmail);

    void deleteCustomer(Long customerId);

    void updateCustomer(Long customerId, String firstName, String lastName, String customerAdress, String customerEmail);

    Customer getCustomerById(Long customerId);

    List<Customer> getAllCustomer();

    void saveCustomerToFile();

}
