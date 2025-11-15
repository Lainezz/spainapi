package com.es.spainapi.commons.impl;

import com.es.spainapi.commons.api.GenericServiceApi;
import com.es.spainapi.error.exception.DuplicateException;
import com.es.spainapi.error.exception.NotFoundException;
import com.es.spainapi.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

abstract public class GenericServiceImpl<T, ID extends Serializable> implements GenericServiceApi<T, ID> {

    abstract protected JpaRepository<T, ID> getDao();

    @Override
    public T insertOne(T entity) {

        ID id = getId(entity);
        if(id != null && getDao().existsById(id)) {
            throw new DuplicateException("Entity with ID " + id + " already exists");
        }
        return getDao().save(entity);
    }

    @Override
    public void deleteOne(ID id) {

        if(id == null || !getDao().existsById(id)) {
            throw new NotFoundException("Entity with ID " + id + " does not exist");
        }
        getDao().deleteById(id);
    }

    @Override
    public T getOne(ID id) {
        return getDao().findById(id).orElse(null);
    }

    @Override
    public List<T> getAll() {
        return getDao().findAll();
    }

    protected ID getId(T entity) {
        if(entity instanceof BaseEntity<?> base) {
            @SuppressWarnings("unchecked")
            ID id = (ID) base.getID();

            return id;
        }
        return null;
    }

}
