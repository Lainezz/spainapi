package com.es.spainapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
@Embeddable
public class MunicipioId implements Serializable {

    @Column(name = "cprov", length = 3, nullable = false)
    private String cprov;

    @Column(name = "cmun", length = 3, nullable = false)
    private String cmun;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MunicipioId that = (MunicipioId) o;
        return Objects.equals(cprov, that.cprov) && Objects.equals(cmun, that.cmun);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cprov, cmun);
    }
}
