package com.exposite.service;

import com.exposit.api.dao.CustomerDao;
import com.exposit.api.service.CustomerService;
import com.exposit.dto.CustomerDto;
import com.exposit.exceptions.DaoException;
import com.exposit.exceptions.ServiceException;
import com.exposit.marshelling.json.MarshallingCustomerJson;
import com.exposit.model.CustomerEntity;
import lombok.extern.log4j.Log4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Log4j
@Service
public class CustomerServiceImpl implements CustomerService {
    private final ModelMapper mapper;
    private final CustomerDao customerDao;

    private static final String CAN_NOT_DELETE_CUSTOMER
            = "can not delete customer";
    private static final String CAN_NOT_UPDATE_CUSTOMER
            = "can not update customer";
    private static final String CAN_NOT_ADD_CUSTOMER
            = "can not add customer";

    @Autowired
    public CustomerServiceImpl(ModelMapper mapper, CustomerDao customerDao) {
        this.mapper = mapper;
        this.customerDao = customerDao;
    }


    @Override
    public void addCustomer(CustomerDto customerDto) {
        if (customerDto.getId() == null) {
            CustomerEntity customer = mapper
                    .map(customerDto, CustomerEntity.class);
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
            CustomerEntity customer = mapper
                    .map(customerDto, CustomerEntity.class);
            customer.setId(id);
            customerDao.update(id, customer);
        } else {
            log.warn(CAN_NOT_UPDATE_CUSTOMER);
            throw new ServiceException(CAN_NOT_UPDATE_CUSTOMER);
        }
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        CustomerEntity customerEntity = customerDao.getById(id);
        return mapper.map(customerEntity, CustomerDto.class);
    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        List<CustomerEntity> customerEntityList = customerDao.getAll();
        Type listType = new TypeToken<List<CustomerDto>>() {
        }.getType();
        return mapper.map(customerEntityList, listType);
    }

    @Override
    public void saveCustomerToFile() {
        MarshallingCustomerJson
                .serializeCustomer(customerDao.getAll());
    }
}