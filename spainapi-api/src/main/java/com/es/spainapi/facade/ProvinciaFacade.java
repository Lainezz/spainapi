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

    private final ProvinciaServiceAPI provinciaService;
    private final ProvinciaMapper provinciaMapper;

    public ProvinciaFacade(ProvinciaServiceAPI provinciaService, ProvinciaMapper provinciaMapper) {
        this.provinciaService = provinciaService;
        this.provinciaMapper = provinciaMapper;
    }

    public List<ProvinciaDTO> getAll() {
        return provinciaMapper.toDtoList(provinciaService.getAll());
    }

    public ProvinciaDTO getOne(String cprov) {
        return provinciaMapper.toDto(provinciaService.getOne(cprov));
    }

    public ProvinciaDTO insertOne(ProvinciaDTO dto) {
        return provinciaMapper.toDto(provinciaService.insertOne(provinciaMapper.toEntity(dto)));
    }

    public void deleteOne(String cprov) {
        provinciaService.deleteOne(cprov);
    }
}
