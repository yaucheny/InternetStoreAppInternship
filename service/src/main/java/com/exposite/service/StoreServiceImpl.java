package com.exposite.service;

import com.exposit.api.dao.StoreDao;
import com.exposit.api.service.IStoreService;

import com.exposit.dao.util.DaoPropertiesHandler;
import com.exposit.dao.util.StoreDaoFactory;
import com.exposit.exceptions.DaoException;
import com.exposit.exceptions.ServiceException;
import com.exposit.marshelling.json.MarshallingStoreJson;
import com.exposit.model.StoreEntity;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
public class StoreServiceImpl implements IStoreService {

    private static final String PROPERTY;

    static {
        PROPERTY = DaoPropertiesHandler
                .getProperty("dao.serialization.config_dao_impl")
                .orElseThrow(() -> new ServiceException("Serialization path not found"));
    }
    private final StoreDao storeDao;
    private static StoreServiceImpl instance;
    private static final String CAN_NOT_DELETE_STORE
            = "can not delete store";
    private static final String CAN_NOT_UPDATE_STORE
            = "can not update store";

    private StoreServiceImpl() {
        storeDao = StoreDaoFactory
                .getStoreDaoFromProperties(PROPERTY);
    }

    public static StoreServiceImpl getInstance() {
        if (instance == null) {
            instance = new StoreServiceImpl();
        }
        return instance;
    }

    @Override
    public StoreEntity addStore(String name, String internetPage,
                                String phoneNumber) {
        StoreEntity store = new StoreEntity(name, internetPage, phoneNumber);
        storeDao.save(store);
        return store;
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
    public void updateStore(Long id, String name, String internetPage,
                            String phoneNumber) {
        if (storeDao.getById(id) != null) {
            StoreEntity store = new StoreEntity(name, internetPage, phoneNumber);
            store.setId(id);
            storeDao.update(id, store);
        } else {
            log.warn(CAN_NOT_UPDATE_STORE);
            throw new ServiceException(CAN_NOT_UPDATE_STORE);
        }
    }

    @Override
    public StoreEntity getStoreById(Long id) {
        return   storeDao.getById(id);
    }

    @Override
    public List<StoreEntity> getAllStore() {
        return storeDao.getAll();
    }

    @Override
    public void saveStoreToFile() {
        MarshallingStoreJson
                .serializeStore(storeDao.getAll());
    }
}
