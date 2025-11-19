package com.es.spainapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MunicipioAllDTO {

    private String cprov;
    private String nprov;
    private List<MunicipioSummaryDTO> municipios;

}
