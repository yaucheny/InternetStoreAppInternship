package com.exposit.dao.daojson;

import com.exposit.api.dao.GenericDao;
import com.exposit.domain.model.db.BaseDb;
import com.exposit.utils.exceptions.DaoException;
import com.exposit.utils.marshelling.MarshallingJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDaoJsonImpl<T extends BaseDb> implements GenericDao<T> {

    private final static Logger log = LoggerFactory.getLogger(AbstractDaoJsonImpl.class);
    private static final String GET_BY_ID_ERROR_MESSAGE = "can not find an entity by id: %d";
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

    @Override
    public void saveToFile(List<T> entity) {
        MarshallingJson.serializeJsonEntity(entity);
    }

    protected void autoLoad(T entity) {
        repository.add(entity);
    }
}

