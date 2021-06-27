package com.exposit.service;

import com.exposit.api.dao.ICustomerDao;
import com.exposit.api.service.ICustomerService;
import com.exposit.dao.CustomerDao;
import com.exposit.exceptions.DaoException;
import com.exposit.exceptions.ServiceException;
import com.exposit.marshelling.MarshallingJsonHandlerCustomer;
import com.exposit.model.Customer;
import com.exposit.model.Store;
import lombok.extern.log4j.Log4j;

import java.util.List;

@Log4j
public class CustomerService implements ICustomerService {

    private final ICustomerDao customerDao;
    private static CustomerService instance;
    private static final String CAN_NOT_DELETE_CUSTOMER = "can not delete customer";
    private static final String CAN_NOT_UPDATE_CUSTOMER = "can not update customer";

    private CustomerService() {
        customerDao = CustomerDao.getInstance();
    }

    public static CustomerService getInstance() {
        if (instance == null) {
            instance = new CustomerService();
        }
        return instance;
    }

    @Override
    public Customer addCustomer(String firstName, String lastName, String customerAddress, String customerEmail) {
        Customer customer = new Customer(firstName, lastName,customerAddress,customerEmail);
        customerDao.save(customer);
        return customer;
    }

    @Override
    public void deleteCustomer(Long customerId) {
        try {
            customerDao.delete(customerDao.getById(customerId));
        } catch (DaoException e) {
            log.warn(CAN_NOT_DELETE_CUSTOMER, e);
            throw new ServiceException(CAN_NOT_DELETE_CUSTOMER, e);
        }
    }

    @Override
    public void updateCustomer(Long customerId, String firstName, String lastName, String customerAdress, String customerEmail) {
        if (customerDao.getById(customerId) != null) {
            Customer customer = new Customer(firstName,lastName,customerAdress,customerEmail);
            customer.setId(customerId);
            customerDao.update(customerId, customer);
        } else {
            log.warn(CAN_NOT_UPDATE_CUSTOMER);
            throw new ServiceException(CAN_NOT_UPDATE_CUSTOMER);
        }
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return customerDao.getById(customerId);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerDao.getAll();
    }

    @Override
    public void saveCustomerToFile() {
        MarshallingJsonHandlerCustomer.serializeCustomer(customerDao.getAll());
    }
}
