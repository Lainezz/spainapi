package com.es.spainapi.service.impl;

import com.es.spainapi.commons.impl.GenericServiceImpl;
import com.es.spainapi.model.Provincia;
import com.es.spainapi.repository.ProvinciaRepository;
import com.es.spainapi.service.api.ProvinciaServiceAPI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProvinciaService extends GenericServiceImpl<Provincia, String> implements ProvinciaServiceAPI {

    private final ProvinciaRepository repository;

    public ProvinciaService(ProvinciaRepository repository) {
        this.repository = repository;
    }

    @Override
    protected JpaRepository<Provincia, String> getDao() {
        return repository;
    }

    @Override
    public String prueba() {
        return "Prueba Provincia";
    }
}
