package com.exposit.dao.daojson;

import com.exposit.api.dao.GenericDao;
import com.exposit.domain.model.db.BaseDb;
import com.exposit.utils.exceptions.NotFoundException;
import com.exposit.utils.marshelling.MarshallingJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
/**
 * Implementation of {@link GenericDao} interface.
 * Implementation works with Jackson API and xml format files
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public abstract class AbstractDaoJsonImpl<T extends BaseDb> implements GenericDao<T> {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractDaoJsonImpl.class);
    private static final String GET_BY_ID_ERROR_LOG = "can not find an entity by id: {}";
    private static final String GET_BY_ID_ERROR_EXCEPTION = "can not find an entity by id: %s";
    protected List<T> repository = new ArrayList<>();

    @Override
    public T getById(Long id) {
        for (T entity : repository) {
            if (entity.getId().equals(id)) {
                return entity;
            }
        }
        LOG.error(GET_BY_ID_ERROR_LOG, id);
        throw new NotFoundException(String.format(GET_BY_ID_ERROR_EXCEPTION, id));
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

