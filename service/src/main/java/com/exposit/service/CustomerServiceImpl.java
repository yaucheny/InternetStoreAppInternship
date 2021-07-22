package com.exposit.service;

import com.exposit.api.dao.CustomerDao;
import com.exposit.api.service.CustomerService;
import com.exposit.dao.util.CustomerDaoFactory;
import com.exposit.dao.util.DaoPropertiesHandler;
import com.exposit.exceptions.DaoException;
import com.exposit.exceptions.ServiceException;
import com.exposit.marshelling.json.MarshallingCustomerJson;
import com.exposit.model.CustomerEntity;
import lombok.extern.log4j.Log4j;

import java.util.List;

@Log4j
public class CustomerServiceImpl implements CustomerService {

    private static final String PROPERTY;

    static {
        PROPERTY = DaoPropertiesHandler.getProperty("dao.serialization.config_dao_impl")
                .orElseThrow(() -> new ServiceException("Serialization path not found"));
    }

    private final CustomerDao customerDao;
    private static CustomerServiceImpl instance;
    private static final String CAN_NOT_DELETE_CUSTOMER
            = "can not delete customer";
    private static final String CAN_NOT_UPDATE_CUSTOMER
            = "can not update customer";

    private CustomerServiceImpl() {
        customerDao = CustomerDaoFactory.getCustomerDaoFromProperties(PROPERTY);
    }

    public static CustomerServiceImpl getInstance() {
        if (instance == null) {
            instance = new CustomerServiceImpl();
        }
        return instance;
    }

    @Override
    public CustomerEntity addCustomer(String firstName, String lastName,
                                      String address, String email) {
        CustomerEntity customer = new CustomerEntity(firstName, lastName,
                address, email);
        customerDao.save(customer);
        return customer;
    }

    @Override
    public void deleteCustomer(Long id) {
        try {
            customerDao.delete(customerDao.getById(id));
        } catch (DaoException e) {
            log.warn(CAN_NOT_DELETE_CUSTOMER, e);
            throw new ServiceException(CAN_NOT_DELETE_CUSTOMER, e);
        }
    }

    @Override
    public void updateCustomer(Long id, String firstName,
                               String lastName, String address,
                               String email) {
        if (customerDao.getById(id) != null) {
            CustomerEntity customer = new CustomerEntity(firstName, lastName,
                    address, email);
            customer.setId(id);
            customerDao.update(id, customer);
        } else {
            log.warn(CAN_NOT_UPDATE_CUSTOMER);
            throw new ServiceException(CAN_NOT_UPDATE_CUSTOMER);
        }
    }

    @Override
    public CustomerEntity getCustomerById(Long id) {
        return customerDao
                .getById(id);
    }

    @Override
    public List<CustomerEntity> getAllCustomer() {
        return customerDao.getAll();
    }

    @Override
    public void saveCustomerToFile() {
        MarshallingCustomerJson
                .serializeCustomer(customerDao.getAll());
    }
}
