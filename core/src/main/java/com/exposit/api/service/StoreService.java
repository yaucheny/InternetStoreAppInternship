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
    /**
     * saves Store.
     *
     * @param storeDto dto object of saving Store.
     * @author Yauheni Markevich
     */
    void addStore(StoreDto storeDto);

    /**
     * Deletes Store.
     *
     * @param id Store with id to delete
     * @throws com.exposit.utils.exceptions.ServiceException if Store was not found
     * @author Yauheni Markevich
     */
    void deleteStore(Long id);

    /**
     * Updates Store.
     *
     * @param id       Store with id to update
     * @param storeDto dto object of searching Store
     * @throws com.exposit.utils.exceptions.ServiceException if Store was not found
     * @author Yauheni Markevich
     */
    void updateStore(Long id, StoreDto storeDto);

    /**
     * Returns Store by id.
     *
     * @param id searching Store
     * @return StoreDto.
     * @throws com.exposit.utils.exceptions.ServiceException if Store was not found
     * @author Yauheni Markevich
     */
    StoreDto getStoreById(Long id);

    /**
     * Gets List of Stores.
     *
     * @return List<StoreDto> of Stores or emptyList
     * @author Yauheni Markevich
     */
    List<StoreDto> getAllStore();

    /**
     * Saves Stores to file.
     *
     * @author Yauheni Markevich
     */
    void saveStoreToFile();
}
