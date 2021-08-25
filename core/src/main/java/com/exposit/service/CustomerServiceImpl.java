package com.exposit.service;

import com.exposit.api.dao.CustomerDao;
import com.exposit.api.service.CustomerService;
import com.exposit.domain.dto.CustomerDto;
import com.exposit.domain.model.db.CustomerDb;
import com.exposit.utils.exceptions.DaoException;
import com.exposit.utils.exceptions.ServiceException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final static Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
    private final ModelMapper mapper;
    private final CustomerDao customerDao;
    private static final String CAN_NOT_DELETE_CUSTOMER = "can not delete customer";
    private static final String CAN_NOT_UPDATE_CUSTOMER = "can not update customer";
    private static final String CAN_NOT_ADD_CUSTOMER = "can not add customer";

    @Override
    public void addCustomer(CustomerDto customerDto) {
        if (customerDto.getId() == null) {
            CustomerDb customer = mapper.map(customerDto, CustomerDb.class);
            customerDao.save(customer);
        } else {
            log.warn(CAN_NOT_ADD_CUSTOMER);
            throw new DaoException(CAN_NOT_ADD_CUSTOMER);
        }
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
    public void updateCustomer(Long id, CustomerDto customerDto) {
        if (customerDao.getById(id) != null) {
            CustomerDb customer = mapper.map(customerDto, CustomerDb.class);
            customer.setId(id);
            customerDao.update(id, customer);
        } else {
            log.warn(CAN_NOT_UPDATE_CUSTOMER);
            throw new ServiceException(CAN_NOT_UPDATE_CUSTOMER);
        }
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        CustomerDb customerDbEntity = customerDao.getById(id);
        return mapper.map(customerDbEntity, CustomerDto.class);
    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        List<CustomerDb> customerDbList = customerDao.getAll();
        Type listType = new TypeToken<List<CustomerDto>>() {
        }.getType();
        return mapper.map(customerDbList, listType);
    }

    @Override
    public void saveCustomerToFile() {
        customerDao.saveToFile(customerDao.getAll());
    }
}