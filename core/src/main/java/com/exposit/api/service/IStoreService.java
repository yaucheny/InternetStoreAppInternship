package com.exposit.api.service;

import com.exposit.domain.dto.StoreDto;

import java.util.List;

public interface IStoreService {

    void addStore(StoreDto storeDto);

    void deleteStore(Long id);

    void updateStore(Long id, StoreDto storeDto);

    StoreDto getStoreById(Long id);

    List<StoreDto> getAllStore();

    void saveStoreToFile();
}
