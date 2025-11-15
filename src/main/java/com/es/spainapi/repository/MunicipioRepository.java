package com.es.spainapi.repository;

import com.es.spainapi.model.Municipio;
import com.es.spainapi.model.MunicipioId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, MunicipioId> {

    Optional<Municipio> findByNmun(String nmun);
    Optional<List<Municipio>> findAllByProvincia_NprovIgnoreCase(String nprov);
    Optional<List<Municipio>> findAllByProvincia_CprovIgnoreCase(String cprov);


}
