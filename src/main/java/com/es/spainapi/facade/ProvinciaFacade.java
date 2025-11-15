package com.es.spainapi.facade;

import com.es.spainapi.dto.ProvinciaDTO;
import com.es.spainapi.model.Provincia;
import com.es.spainapi.service.api.ProvinciaServiceAPI;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Facade class. This will have the cast between DTO and Entities
 */
@Service
public class ProvinciaFacade {

    private final ProvinciaServiceAPI service;
    private final ModelMapper mm;

    public ProvinciaFacade(ProvinciaServiceAPI service, ModelMapper mm) {
        this.service = service;
        this.mm = mm;
    }

    public List<ProvinciaDTO> getAll() {
        return service.getAll().stream().map(p -> mm.map(p, ProvinciaDTO.class)).collect(Collectors.toList());
    }

    public ProvinciaDTO getOne(String id) {
        return mm.map(service.getOne(id), ProvinciaDTO.class);
    }

    public ProvinciaDTO insertOne(ProvinciaDTO dto) {
        return mm.map(service.insertOne(mm.map(dto, Provincia.class)), ProvinciaDTO.class);
    }

    public void deleteOne(String id) {
        service.deleteOne(id);
    }
}
