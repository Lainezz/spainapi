package com.es.spainapi.commons.api;

import java.io.Serializable;
import java.util.List;

public interface GenericServiceApi<T, ID extends Serializable > {

    T insertOne(T entity);
    void deleteOne(ID id);
    T getOne(ID id);
    List<T> getAll();

}
