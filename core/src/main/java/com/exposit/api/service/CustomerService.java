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
    /**
     * Returns Customer by id.
     *
     * @param customerDto dto object of saving Customer
     * @author Yauheni Markevich
     */
    void addCustomer(CustomerDto customerDto);

    /**
     * Deletes Customer.
     *
     * @param id Customer with id to delete
     * @throws com.exposit.utils.exceptions.ServiceException if Customer was not found
     * @author Yauheni Markevich
     */
    void deleteCustomer(Long id);

    /**
     * Updates Customer.
     *
     * @param id          Customer with id to update
     * @param customerDto dto object of searching Customer
     * @throws com.exposit.utils.exceptions.ServiceException if Customer was not found
     * @author Yauheni Markevich
     */
    void updateCustomer(Long id, CustomerDto customerDto);

    /**
     * Returns Customer by id.
     *
     * @param id of searching Customer
     * @return CustomerDto.
     * @throws com.exposit.utils.exceptions.ServiceException if Customer was not found
     * @author Yauheni Markevich
     */
    CustomerDto getCustomerById(Long id);

    /**
     * Gets List of Customers.
     *
     * @return List<CustomerDto> of Customers or emptyList
     * @author Yauheni Markevich
     */
    List<CustomerDto> getAllCustomer();

    /**
     * Saves Customers to file.
     *
     * @author Yauheni Markevich
     */
    void saveCustomerToFile();

}
