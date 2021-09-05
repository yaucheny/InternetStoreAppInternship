package com.exposit.api.service;

import com.exposit.domain.dto.StoreDto;

import java.util.List;
/**
 * Service interface for{@link com/exposit/domain/model/db/StoreDb.java}.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public interface StoreService {

    void addStore(StoreDto storeDto);

    void deleteStore(Long id);

    void updateStore(Long id, StoreDto storeDto);

    StoreDto getStoreById(Long id);

    List<StoreDto> getAllStore();

    void saveStoreToFile();
}
