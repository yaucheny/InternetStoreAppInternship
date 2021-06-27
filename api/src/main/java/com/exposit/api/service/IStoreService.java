package com.exposit.api.service;

import com.exposit.model.Customer;
import com.exposit.model.Store;

import java.util.List;

public interface IStoreService {

    Store addStore(String storeName, String internetPage, String phoneNumber);

    void deleteStore(Long storeId);

    void updateStore(Long storeId,String storeName, String internetPage, String phoneNumber);

    Store getStoreById(Long storeId);

    List<Store> getAllStore();

    void saveStoreToFile();
}
