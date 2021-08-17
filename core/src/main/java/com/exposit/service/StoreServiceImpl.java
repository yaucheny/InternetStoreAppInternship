package com.exposit.service;

import com.exposit.api.dao.StoreDao;
import com.exposit.api.service.IStoreService;
import com.exposit.domain.dto.StoreDto;
import com.exposit.utils.exceptions.DaoException;
import com.exposit.utils.exceptions.ServiceException;
import com.exposit.utils.marshelling.json.MarshallingStoreJson;
import com.exposit.domain.model.db.StoreDb;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Log4j
@RequiredArgsConstructor
@Service
public class StoreServiceImpl implements IStoreService {

    private final ModelMapper mapper;
    private final StoreDao storeDao;
    private static final String CAN_NOT_DELETE_STORE = "can not delete store";
    private static final String CAN_NOT_UPDATE_STORE = "can not update store";
    private static final String CAN_NOT_ADD_STORE = "can not add store";

    @Override
    public void addStore(StoreDto storeDto) {
        if (storeDto.getId() == null) {
            StoreDb store = mapper.map(storeDto, StoreDb.class);
            storeDao.save(store);
        } else {
            log.warn(CAN_NOT_ADD_STORE);
            throw new DaoException(CAN_NOT_ADD_STORE);
        }
    }

    @Override
    public void deleteStore(Long id) {
        try {
            storeDao.delete(storeDao.getById(id));
        } catch (DaoException e) {
            log.warn(CAN_NOT_DELETE_STORE, e);
            throw new ServiceException(CAN_NOT_DELETE_STORE, e);
        }
    }

    @Override
    public void updateStore(Long id, StoreDto storeDto) {
        if (storeDao.getById(id) != null) {
            StoreDb store = mapper.map(storeDto, StoreDb.class);
            store.setId(id);
            storeDao.update(id, store);
        } else {
            log.warn(CAN_NOT_UPDATE_STORE);
            throw new ServiceException(CAN_NOT_UPDATE_STORE);
        }
    }

    @Override
    public StoreDto getStoreById(Long id) {
        storeDao.getById(id).getClass();
        StoreDb storeDbEntity = storeDao.getById(id);
        return mapper.map(storeDbEntity, StoreDto.class);
    }

    @Override
    public List<StoreDto> getAllStore() {
        List<StoreDb> storeDbEntityList = storeDao.getAll();
        Type listType = new TypeToken<List<StoreDto>>() {
        }.getType();
        return mapper.map(storeDbEntityList, listType);
    }

    @Override
    public void saveStoreToFile() {
        MarshallingStoreJson.serializeStore(storeDao.getAll());
    }
}