package com.es.spainapi.service.api;

import com.es.spainapi.commons.api.GenericServiceApi;
import com.es.spainapi.model.Provincia;
import org.springframework.stereotype.Service;

public interface ProvinciaServiceAPI extends GenericServiceApi<Provincia, String> {

    String prueba();
}
