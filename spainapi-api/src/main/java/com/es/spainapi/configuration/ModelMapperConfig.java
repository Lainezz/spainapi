package com.es.spainapi.configuration;

import com.es.spainapi.dto.MunicipioAllDTO;
import com.es.spainapi.dto.MunicipioDTO;
import com.es.spainapi.dto.MunicipioSummaryDTO;
import com.es.spainapi.model.Municipio;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mm = new ModelMapper();

        // Safer defaults for backend apps
        mm.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT) // avoid accidental matches
                .setSkipNullEnabled(true)                       // ignore nulls on update/merge
                .setFieldMatchingEnabled(true)                  // allow field->field (no getters)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);

        // Example: global condition to map only non-empty strings
        mm.getConfiguration().setPropertyCondition(ctx -> {
            Object src = ctx.getSource();
            return !(src instanceof String s) || !s.isBlank();
        });

        // -------- Municipio -> MunicipioDto --------
        TypeMap<Municipio, MunicipioDTO> m2d = mm.createTypeMap(Municipio.class, MunicipioDTO.class);
        m2d.addMappings(m -> {
            m.map(src -> src.getID().getCprov(), MunicipioDTO::setCprov);
            m.map(src -> src.getID().getCmun(), MunicipioDTO::setCmun);
            m.map(Municipio::getNmun,       MunicipioDTO::setNmun);
            // Si quisieras incluir datos de provincia:
            m.map(src -> src.getProvincia().getNprov(), MunicipioDTO::setNprov);
        });

        // -------- Municipio -> MunicipioAllDto --------
        // Mapping Municipio -> MunicipioSummaryDTO
        mm.addMappings(new PropertyMap<Municipio, MunicipioSummaryDTO>() {
            @Override
            protected void configure() {
                map().setCmun(source.getID().getCmun()); // from EmbeddedId
                map().setNmun(source.getNmun());
            }
        });

        // Mapping Municipio -> MunicipioAllDTO (for grouping)
        mm.addMappings(new PropertyMap<Municipio, MunicipioAllDTO>() {
            @Override
            protected void configure() {
                map().setCprov(source.getID().getCprov());
                map().setNprov(source.getProvincia().getNprov()); // if Provincia is relation
                // municipios list will be filled manually (aggregation step)
            }
        });


        return mm;
    }

}
