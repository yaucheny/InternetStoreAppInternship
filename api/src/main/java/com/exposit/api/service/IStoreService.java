package com.exposit.api.service;

import com.exposit.model.StoreEntity;

import java.util.List;

public interface IStoreService {

    StoreEntity addStore(String name, String internetPage, String phoneNumber);

    void deleteStore(Long id);

    void updateStore(Long id, String name,
                     String internetPage, String phoneNumber);

    StoreEntity getStoreById(Long id);

    List<StoreEntity> getAllStore();

    void saveStoreToFile();
}
