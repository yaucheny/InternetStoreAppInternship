package com.exposit.api.dao;

import com.exposit.domain.model.db.BaseDb;

import java.util.List;

/**
 * Interface for a Data Access Object that can be used for a single specified type domain object.
 * * @param <T> Type of element stored in Class
 * @author Yauheni Markevich
 * @version 1.0
 */
public interface GenericDao<T extends BaseDb> {

    /**
     * Returns entity by id.
     *
     * @param id id of searching entity
     * @return found id of searching entity
     * @throws com.exposit.utils.exceptions.NotFoundException if entity was not found
     * @author Yauheni Markevich
     */
    T getById(Long id);

    /**
     * Deletes entity.
     *
     * @param entity to delete
     * @throws com.exposit.utils.exceptions.NotFoundException if entity was not found
     * @author Yauheni Markevich
     */
    void delete(T entity);

    /**
     * Updates entity.
     *
     * @param id     id  of updating entity
     * @param entity to update
     * @throws com.exposit.utils.exceptions.NotFoundException if entity was not found
     * @author Yauheni Markevich
     */
    void update(Long id, T entity);

    /**
     * Gets List<T> of entities.
     *
     * @return List<T> of entities or emptyList
     * @author Yauheni Markevich
     */
    List<T> getAll();

    /**
     * Saves to file entity.
     *
     * @param entity to save
     * @author Yauheni Markevich
     */
    void saveToFile(List<T> entity);

    /**
     * Saves List<T> entities to file.
     *
     * @param entity List<T> entities
     * @author Yauheni Markevich
     */
    void save(T entity);
}
