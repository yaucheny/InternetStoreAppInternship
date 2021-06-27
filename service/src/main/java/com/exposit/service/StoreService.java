package com.exposit.service;

import com.exposit.api.dao.IStoreDao;
import com.exposit.api.service.IStoreService;
import com.exposit.dao.StoreDao;
import com.exposit.exceptions.DaoException;
import com.exposit.exceptions.ServiceException;
import com.exposit.idGenerators.IdGenerator;
import com.exposit.marshelling.MarshallingJsonHandlerStore;
import com.exposit.model.Store;
import lombok.extern.log4j.Log4j;

import java.util.List;

@Log4j
public class StoreService implements IStoreService {
    private final IStoreDao storeDao;
    private static StoreService instance;
    private static final String CAN_NOT_DELETE_STORE = "can not delete store";
    private static final String CAN_NOT_UPDATE_STORE = "can not update store";

    private StoreService() {
        storeDao = StoreDao.getInstance();
    }

    public static StoreService getInstance() {
        if (instance == null) {
            instance = new StoreService();
        }
        return instance;
    }

    @Override
    public Store addStore(String storeName, String internetPage, String phoneNumber) {
        Store store = new Store(storeName, internetPage, phoneNumber);
        storeDao.save(store);
        return store;
    }

    @Override
    public void deleteStore(Long storeId) {
        try {
            storeDao.delete(storeDao.getById(storeId));
        } catch (DaoException e) {
            log.warn(CAN_NOT_DELETE_STORE, e);
            throw new ServiceException(CAN_NOT_DELETE_STORE, e);
        }
    }

    @Override
    public void updateStore(Long storeId, String storeName, String internetPage, String phoneNumber) {
        if (storeDao.getById(storeId) != null) {
            Store store = new Store(storeName, internetPage, phoneNumber);
            store.setId(storeId);
            storeDao.update(storeId, store);
        } else {
            log.warn(CAN_NOT_UPDATE_STORE);
            throw new ServiceException(CAN_NOT_UPDATE_STORE);
        }
    }

    @Override
    public Store getStoreById(Long storeId) {
      return   storeDao.getById(storeId);
    }

    @Override
    public List<Store> getAllStore() {
        return storeDao.getAll();
    }

    @Override
    public void saveStoreToFile() {
        MarshallingJsonHandlerStore.serializeStore(storeDao.getAll());
    }
}
