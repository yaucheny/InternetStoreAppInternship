package com.exposit.api.service;

import com.exposit.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    void addCustomer(CustomerDto customerDto);

    void deleteCustomer(Long id);

    void updateCustomer(Long id, CustomerDto customerDto);

    CustomerDto getCustomerById(Long id);

    List<CustomerDto> getAllCustomer();

    void saveCustomerToFile();

}
