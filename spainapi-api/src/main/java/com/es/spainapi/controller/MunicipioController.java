package com.es.spainapi.controller;


import com.es.spainapi.dto.MunicipioAllDTO;
import com.es.spainapi.dto.MunicipioDTO;
import com.es.spainapi.facade.MunicipioFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/municipios")
public class MunicipioController {

    private final MunicipioFacade facade;

    public MunicipioController(MunicipioFacade facade) {
        this.facade = facade;
    }

    @GetMapping("/byNmun/{nmun}")
    public ResponseEntity<MunicipioDTO> getOneByNmun(@PathVariable String nmun) {
        return ResponseEntity.ok(facade.getOneByNmun(nmun));
    }

    @GetMapping("/allByNprov/{nprov}")
    public ResponseEntity<MunicipioAllDTO> getallByNprov(@PathVariable String nprov) {
        return ResponseEntity.ok(facade.getallByNprov(nprov));
    }

    @GetMapping("/allByCprov/{cprov}")
    public ResponseEntity<MunicipioAllDTO> getallByCprov(@PathVariable String cprov) {
        return ResponseEntity.ok(facade.getallByCprov(cprov));
    }


}
