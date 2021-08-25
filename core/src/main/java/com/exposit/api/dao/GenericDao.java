package com.exposit.api.dao;

import com.exposit.domain.model.db.BaseDb;

import java.util.List;

public interface GenericDao<T extends BaseDb> {

    T getById(Long id);

    void delete(T entity);

    void update(Long id, T entity);

    List<T> getAll();

    void saveToFile(List<T> entity);

    void save(T entity);
}
