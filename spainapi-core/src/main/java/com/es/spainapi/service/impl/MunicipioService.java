package com.es.spainapi.service.impl;

import com.es.spainapi.commons.impl.GenericServiceImpl;
import com.es.spainapi.exception.NotFoundException;
import com.es.spainapi.model.Municipio;
import com.es.spainapi.model.MunicipioId;
import com.es.spainapi.repository.MunicipioRepository;
import com.es.spainapi.service.api.MunicipioServiceAPI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunicipioService extends GenericServiceImpl<Municipio, MunicipioId> implements MunicipioServiceAPI {

    private final MunicipioRepository municipioRepository;

    public MunicipioService(MunicipioRepository municipioRepository) {
        this.municipioRepository = municipioRepository;
    }

    @Override
    protected JpaRepository<Municipio, MunicipioId> getDao() {
        return municipioRepository;
    }

    @Override
    public Municipio findByNmun(String nmun) {
        return municipioRepository.findByNmun(nmun).orElseThrow(
                () -> new NotFoundException("Municipio "+ nmun +" not found")
        );
    }

    @Override
    public List<Municipio> getAllByNprov(String nprov) {
        return municipioRepository.findAllByProvincia_NprovIgnoreCase(nprov).orElseThrow(
                () -> new NotFoundException("Provincia "+ nprov +" not found")
        );
    }

    @Override
    public List<Municipio> getAllByCprov(String cprov) {
        return municipioRepository.findAllByProvincia_CprovIgnoreCase(cprov).orElseThrow(
                () -> new NotFoundException("Provincia "+ cprov +" not found")
        );
    }
}
