package com.es.spainapi.mapper;

import com.es.spainapi.dto.ProvinciaDTO;
import com.es.spainapi.model.Provincia;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ProvinciaMapper {

    ProvinciaDTO toDto(Provincia entity);

    Provincia toEntity(ProvinciaDTO dto);

    List<ProvinciaDTO> toDtoList(List<Provincia> entities);
}
