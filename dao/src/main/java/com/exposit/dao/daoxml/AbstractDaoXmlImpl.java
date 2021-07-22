package com.exposit.dao.daoxml;

import com.exposit.api.dao.GenericDao;
import com.exposit.exceptions.DaoException;
import com.exposit.model.AEntity;
import lombok.extern.log4j.Log4j;

import java.util.ArrayList;
import java.util.List;

@Log4j
public class AbstractDaoXmlImpl<T extends AEntity> implements GenericDao<T> {

    private static final String GET_BY_ID_ERROR_MESSAGE
            = "can not find an entity by id: %d";
    protected List<T> repository = new ArrayList<>();

    @Override
    public T getById(Long id) {
        for (T entity : repository) {
            if (id.equals(entity.getId())) {
                return entity;
            }
        }
        log.warn(String.format(GET_BY_ID_ERROR_MESSAGE, id));
        throw new DaoException(String.format(GET_BY_ID_ERROR_MESSAGE, id));
    }

    @Override
    public void delete(T entity) {
        repository.remove(entity);
    }

    @Override
    public void update(Long id, T entity) {
        int a = (Math.toIntExact(id) - 1);
        repository.set(a, entity);
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(repository);
    }
}
