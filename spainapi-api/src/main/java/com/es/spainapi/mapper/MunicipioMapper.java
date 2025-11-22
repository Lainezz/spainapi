package com.es.spainapi.mapper;

import com.es.spainapi.dto.MunicipioAllDTO;
import com.es.spainapi.dto.MunicipioDTO;
import com.es.spainapi.dto.MunicipioSummaryDTO;
import com.es.spainapi.model.Municipio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface MunicipioMapper {

    @Mapping(target = "cprov", source = "municipioId.cprov")
    @Mapping(target = "cmun",  source = "municipioId.cmun")
    @Mapping(target = "nprov", source = "provincia.nprov")
    @Mapping(target = "nmun",  source = "nmun")
    MunicipioDTO toDto(Municipio municipio);

    @Mapping(target = "municipioId.cprov", source = "cprov")
    @Mapping(target = "municipioId.cmun",  source = "cmun")
    @Mapping(target = "nmun",              source = "nmun")
    @Mapping(target = "mehCd",             ignore = true)
    @Mapping(target = "mehCmc",            ignore = true)
    @Mapping(target = "provincia",         ignore = true)  // la pone el servicio
    Municipio toEntity(MunicipioDTO dto);

    @Mapping(target = "cmun", source = "municipioId.cmun")
    @Mapping(target = "nmun", source = "nmun")
    MunicipioSummaryDTO toSummaryDto(Municipio entity);

    default MunicipioAllDTO toAllDto(List<Municipio> municipios) {

        if (municipios == null || municipios.isEmpty()) {
            return null;
        }

        // Tomamos la provincia del primer municipio
        Municipio first = municipios.get(0);

        MunicipioAllDTO dto = new MunicipioAllDTO();
        dto.setCprov(first.getMunicipioId().getCprov());
        dto.setNprov(first.getProvincia().getNprov());

        // Convertimos la lista de municipios a lista de summary DTOs
        dto.setMunicipios(
                municipios.stream()
                        .map(this::toSummaryDto)
                        .toList()
        );

        return dto;
    }

}
