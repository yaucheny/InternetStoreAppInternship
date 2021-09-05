package com.exposit.dao.daorepository;

import com.exposit.api.dao.CustomerDao;
import com.exposit.dao.daorepository.repository.CustomerRepository;
import com.exposit.domain.model.db.CustomerDb;
import com.exposit.domain.model.entity.CustomerEntity;
import com.exposit.utils.exceptions.NotFoundException;
import com.exposit.utils.marshelling.MarshallingXml;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;
/**
 * Implementation of {@link CustomerDao} interface.
 * Implementation works with spring data JPA and postgres database
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public class CustomerDaoRepositoryImpl implements CustomerDao {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerDaoRepositoryImpl.class);
    private static final String GET_BY_ID_ERROR_LOG = "can not find an entity by id: {}";
    private static final String GET_BY_ID_ERROR_EXCEPTION = "can not find an entity by id: %s";

    private CustomerRepository customerRepository;
    private ModelMapper mapper;


    @Override
    @Transactional
    public void save(CustomerDb customerDb) {
        if (customerDb.getId() == null) {
            CustomerEntity customerEntity = mapper.map(customerDb, CustomerEntity.class);
            customerRepository.save(customerEntity);
        }
    }

    @Override
    @Transactional
    public void saveToFile(List<CustomerDb> entity) {
        MarshallingXml.serializeJsonEntity(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public CustomerDb getById(Long id) {
        try {
            CustomerEntity customerEntity = customerRepository.getById(id);
            return mapper.map(customerEntity, CustomerDb.class);
        } catch (Exception e) {
            LOG.error(GET_BY_ID_ERROR_LOG, id);
            throw new NotFoundException(String.format(GET_BY_ID_ERROR_EXCEPTION, id));
        }
    }

    @Override
    @Transactional
    public void delete(CustomerDb customerDb) {
        if (customerDb.getId() != null) {
            CustomerEntity categoryEntity = mapper.map(customerDb, CustomerEntity.class);
            customerRepository.delete(categoryEntity);
        }
    }

    @Override
    @Transactional
    public void update(Long id, CustomerDb customerDb) {
        if (customerDb.getId() != null) {
            CustomerEntity customerEntityToUpdate = customerRepository.getById(id);
            mapper.map(customerDb, CustomerEntity.class);
            customerEntityToUpdate.setAddress(customerDb.getAddress());
            customerEntityToUpdate.setEmail(customerDb.getEmail());
            customerEntityToUpdate.setFirstName(customerDb.getFirstName());
            customerEntityToUpdate.setLastName(customerDb.getLastName());
            customerRepository.save(customerEntityToUpdate);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerDb> getAll() {
        List<CustomerEntity> customerEntityList = customerRepository.findAll();
        Type listType = new TypeToken<List<CustomerDb>>() {
        }.getType();
        return mapper.map(customerEntityList, listType);
    }

    @Autowired
    public void setMapper(ModelMapper mapper1) {
        this.mapper = mapper1;
    }

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository1) {
        this.customerRepository = customerRepository1;
    }
}

