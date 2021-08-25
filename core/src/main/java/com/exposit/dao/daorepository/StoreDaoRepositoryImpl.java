package com.exposit.dao.daorepository;

import com.exposit.api.dao.StoreDao;
import com.exposit.dao.daorepository.repository.StoreRepository;
import com.exposit.domain.model.db.StoreDb;
import com.exposit.domain.model.entity.StoreEntity;
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

public class StoreDaoRepositoryImpl implements StoreDao {

    private static final Logger LOG = LoggerFactory.getLogger(StoreDaoRepositoryImpl.class);
    private static final String GET_BY_ID_ERROR_LOG = "can not find an entity by id: {}";
    private static final String GET_BY_ID_ERROR_EXCEPTION = "can not find an entity by id: %s";

    private StoreRepository storeRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    @Transactional
    public void save(StoreDb storeDb) {
        if (storeDb.getId() == null) {
            StoreEntity categoryEntity = mapper.map(storeDb, StoreEntity.class);
            storeRepository.save(categoryEntity);
        }
    }

    @Override
    @Transactional
    public void saveToFile(List<StoreDb> entity) {
        MarshallingXml.serializeJsonEntity(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public StoreDb getById(Long id) {
        try {
            StoreEntity storeEntity = storeRepository.getById(id);
            return mapper.map(storeEntity, StoreDb.class);
        } catch (Exception e) {
            LOG.error(GET_BY_ID_ERROR_LOG, id);
            throw new NotFoundException(String.format(GET_BY_ID_ERROR_EXCEPTION, id));
        }
    }

    @Override
    @Transactional
    public void delete(StoreDb storeDb) {
        if (storeDb.getId() != null) {
            StoreEntity storeEntity = mapper.map(storeDb, StoreEntity.class);
            storeRepository.delete(storeEntity);
        }
    }

    @Override
    @Transactional
    public void update(Long id, StoreDb storeDb) {
        if (storeDb.getId() != null) {
            StoreEntity storeEntityToUpdate = storeRepository.getById(id);
            StoreEntity storeEntity = mapper.map(storeDb, StoreEntity.class);
            storeEntityToUpdate.setInternetPage(storeEntity.getName());
            storeEntityToUpdate.setName(storeEntity.getInternetPage());
            storeEntityToUpdate.setPhoneNumber(storeEntity.getPhoneNumber());
            storeRepository.save(storeEntityToUpdate);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<StoreDb> getAll() {
        List<StoreEntity> storeEntityList = storeRepository.findAll();
        Type listType = new TypeToken<List<StoreDb>>() {
        }.getType();
        return mapper.map(storeEntityList, listType);
    }

    @Autowired
    public void setMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }
}

