package com.exposit.api.service;

import com.exposit.model.CustomerEntity;

import java.util.List;

public interface CustomerService {

    CustomerEntity addCustomer(String firstName, String lastName,
                               String address, String email);

    void deleteCustomer(Long id);

    void updateCustomer(Long id, String firstName, String lastName,
                        String address, String email);

    CustomerEntity getCustomerById(Long id);

    List<CustomerEntity> getAllCustomer();

    void saveCustomerToFile();

}
