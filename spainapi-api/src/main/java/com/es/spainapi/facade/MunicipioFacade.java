package com.es.spainapi.facade;

import com.es.spainapi.dto.MunicipioAllDTO;
import com.es.spainapi.dto.MunicipioDTO;
import com.es.spainapi.mapper.MunicipioMapper;
import com.es.spainapi.model.Municipio;
import com.es.spainapi.model.MunicipioId;
import com.es.spainapi.service.api.MunicipioServiceAPI;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunicipioFacade {

    private final MunicipioServiceAPI municipioService;
    private final MunicipioMapper municipioMapper;

    public MunicipioFacade(MunicipioServiceAPI municipioService, MunicipioMapper municipioMapper) {
        this.municipioService = municipioService;
        this.municipioMapper = municipioMapper;
    }


    public MunicipioDTO getOneByNmun(String nmun) {
        return municipioMapper.toDto(municipioService.findByNmun(nmun));
    }

    public MunicipioDTO getOneByMunId(String cprov, String cmun) {
        MunicipioId municipioId = new MunicipioId(cprov, cmun);
        return municipioMapper.toDto(municipioService.getOne(municipioId));
    }

    public MunicipioAllDTO getallByNprov(String nprov) {
        List<Municipio> municipios = municipioService.getAllByNprov(nprov);
        return municipioMapper.toAllDto(municipios);
    }

    public MunicipioAllDTO getallByCprov(String cprov) {
        List<Municipio> municipios = municipioService.getAllByCprov(cprov);
        return municipioMapper.toAllDto(municipios);
    }

}
