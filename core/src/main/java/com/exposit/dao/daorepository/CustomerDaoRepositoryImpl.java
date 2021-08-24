package com.exposit.dao.daorepository;

import com.exposit.api.dao.CustomerDao;
import com.exposit.dao.daorepository.repository.CustomerRepository;
import com.exposit.domain.model.db.CustomerDb;
import com.exposit.domain.model.entity.CustomerEntity;
import com.exposit.utils.marshelling.MarshallingXml;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;
@Transactional
public class CustomerDaoRepositoryImpl implements CustomerDao {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public void save(CustomerDb customerDb) {
        if (customerDb.getId() == null) {
            CustomerEntity customerEntity = mapper.map(customerDb, CustomerEntity.class);
            customerRepository.save(customerEntity);
        }
    }

    @Override
    public void saveToFile(List<CustomerDb> entity) {
        MarshallingXml.serializeJsonEntity(entity);
    }

    @Override
    public CustomerDb getById(Long id) {
        CustomerEntity customerEntity = customerRepository.getById(id);
        return mapper.map(customerEntity, CustomerDb.class);
    }

    @Override
    public void delete(CustomerDb customerDb) {
        if (customerDb.getId() != null) {
            CustomerEntity categoryEntity = mapper.map(customerDb, CustomerEntity.class);
            customerRepository.delete(categoryEntity);
        }
    }

    @Override
    public void update(Long id, CustomerDb customerDb) {
        if (customerDb.getId() != null) {
            CustomerEntity customerEntityToUpdate = customerRepository.getById(id);
            CustomerEntity customerEntity = mapper.map(customerDb, CustomerEntity.class);
            customerEntityToUpdate.setAddress(customerDb.getAddress());
            customerEntityToUpdate.setEmail(customerDb.getEmail());
            customerEntityToUpdate.setFirstName(customerDb.getFirstName());
            customerEntityToUpdate.setLastName(customerDb.getLastName());
            customerRepository.save(customerEntityToUpdate);
        }
    }

    @Override
    public List<CustomerDb> getAll() {
        List<CustomerEntity> customerEntityList = customerRepository.findAll();
        Type listType = new TypeToken<List<CustomerDb>>() {
        }.getType();
        return mapper.map(customerEntityList, listType);
    }
}

