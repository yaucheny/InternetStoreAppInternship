package com.exposit.api.service;

import com.exposit.domain.dto.CustomerDto;

import java.util.List;
/**
 * Service interface for{@link com/exposit/domain/model/db/Customer.java}.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public interface CustomerService {

    void addCustomer(CustomerDto customerDto);

    void deleteCustomer(Long id);

    void updateCustomer(Long id, CustomerDto customerDto);

    CustomerDto getCustomerById(Long id);

    List<CustomerDto> getAllCustomer();

    void saveCustomerToFile();

}
