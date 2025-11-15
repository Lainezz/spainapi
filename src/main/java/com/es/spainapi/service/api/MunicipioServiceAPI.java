package com.es.spainapi.service.api;

import com.es.spainapi.commons.api.GenericServiceApi;
import com.es.spainapi.dto.MunicipioDTO;
import com.es.spainapi.model.Municipio;
import com.es.spainapi.model.MunicipioId;

import java.util.List;

public interface MunicipioServiceAPI extends GenericServiceApi<Municipio, MunicipioId> {

    Municipio findByNmun(String nmun);
    List<Municipio> getAllByNprov(String nprov);
    List<Municipio> getAllByCprov(String cprov);

}
