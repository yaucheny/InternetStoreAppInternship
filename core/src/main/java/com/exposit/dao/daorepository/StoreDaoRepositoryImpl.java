package com.exposit.dao.daorepository;

import com.exposit.api.dao.StoreDao;
import com.exposit.dao.daorepository.repository.StoreRepository;
import com.exposit.domain.model.db.StoreDb;
import com.exposit.domain.model.entity.StoreEntity;
import com.exposit.utils.marshelling.MarshallingXml;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;
@Transactional
public class StoreDaoRepositoryImpl implements StoreDao {

    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public void save(StoreDb storeDb) {
        if (storeDb.getId() == null) {
            StoreEntity categoryEntity = mapper.map(storeDb, StoreEntity.class);
            storeRepository.save(categoryEntity);
        }
    }

    @Override
    public void saveToFile(List<StoreDb> entity) {
        MarshallingXml.serializeJsonEntity(entity);
    }

    @Override
    public StoreDb getById(Long id) {
        StoreEntity storeEntity = storeRepository.getById(id);
        return mapper.map(storeEntity, StoreDb.class);
    }

    @Override
    public void delete(StoreDb storeDb) {
        if (storeDb.getId() != null) {
            StoreEntity storeEntity = mapper.map(storeDb, StoreEntity.class);
            storeRepository.delete(storeEntity);
        }
    }

    @Override
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
    public List<StoreDb> getAll() {
        List<StoreEntity> storeEntityList = storeRepository.findAll();
        Type listType = new TypeToken<List<StoreDb>>() {
        }.getType();
        return mapper.map(storeEntityList, listType);
    }
}

