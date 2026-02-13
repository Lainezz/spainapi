package com.es.spainapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "municipios")
public class Municipio extends BaseEntity<MunicipioId> {

    @EmbeddedId
    private MunicipioId municipioId;

    @Column(name = "nmun", length = 150, nullable = false)
    private String nmun;

    // Códigos MEH
    @Column(name = "meh_cd", length = 3)
    private String mehCd;

    @Column(name = "meh_cmc", length = 3)
    private String mehCmc;

    // Relación con Provincia
    @MapsId("cprov") // vincula el campo cp de la PK con la relación
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cprov", referencedColumnName = "cprov", nullable = false)
    private Provincia provincia;


    @Override
    public MunicipioId getID() {
        return municipioId;
    }
}
