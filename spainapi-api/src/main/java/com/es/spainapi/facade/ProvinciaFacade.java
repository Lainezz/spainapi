package com.es.spainapi.facade;

import com.es.spainapi.dto.ProvinciaDTO;
import com.es.spainapi.mapper.ProvinciaMapper;
import com.es.spainapi.service.api.ProvinciaServiceAPI;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Facade class. This will have the cast between DTO and Entities
 */
@Service
public class ProvinciaFacade {

    private final ProvinciaServiceAPI service;
    private final ProvinciaMapper provinciaMapper;

    public ProvinciaFacade(ProvinciaServiceAPI service, ProvinciaMapper provinciaMapper) {
        this.service = service;
        this.provinciaMapper = provinciaMapper;
    }

    public List<ProvinciaDTO> getAll() {
        return provinciaMapper.toDtoList(service.getAll());
    }

    public ProvinciaDTO getOne(String cprov) {
        return provinciaMapper.toDto(service.getOne(cprov));
    }

    public ProvinciaDTO insertOne(ProvinciaDTO dto) {
        return provinciaMapper.toDto(service.insertOne(provinciaMapper.toEntity(dto)));
    }

    public void deleteOne(String id) {
        service.deleteOne(id);
    }
}
