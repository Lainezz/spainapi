package com.es.spainapi.facade;

import com.es.spainapi.dto.MunicipioAllDTO;
import com.es.spainapi.dto.MunicipioDTO;
import com.es.spainapi.dto.MunicipioSummaryDTO;
import com.es.spainapi.model.Municipio;
import com.es.spainapi.service.api.MunicipioServiceAPI;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunicipioFacade {

    private final MunicipioServiceAPI service;
    private final ModelMapper mm;

    public MunicipioFacade(MunicipioServiceAPI service, ModelMapper mm) {
        this.service = service;
        this.mm = mm;
    }


    public MunicipioDTO getOneByNmun(String nmun) {

        return mm.map(service.findByNmun(nmun), MunicipioDTO.class);
    }

    public MunicipioAllDTO getallByNprov(String nprov) {

        List<Municipio> entities = service.getAllByNprov(nprov);

        return getMunicipioAllDTO(entities);

    }

    public MunicipioAllDTO getallByCprov(String cprov) {

        List<Municipio> entities = service.getAllByCprov(cprov);

        return getMunicipioAllDTO(entities);

    }

    private MunicipioAllDTO getMunicipioAllDTO(List<Municipio> entities) {
        List<MunicipioSummaryDTO> municipios = entities.stream()
                .map(municipio -> mm.map(municipio, MunicipioSummaryDTO.class))
                .toList();

        MunicipioAllDTO allMunicipios = new MunicipioAllDTO();
        allMunicipios.setMunicipios(municipios);
        allMunicipios.setNprov(entities.get(0).getProvincia().getNprov());
        allMunicipios.setCprov(entities.get(0).getProvincia().getCprov());

        return allMunicipios;
    }
}
