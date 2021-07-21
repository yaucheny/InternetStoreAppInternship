package com.exposit.api.dao;

import com.exposit.model.AEntity;

import java.util.List;

public interface GenericDao<T extends AEntity> {
    T getById(Long id);

    void delete(T entity);

    void update(Long id, T entity);

    List<T> getAll();

}
