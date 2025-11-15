package com.es.spainapi.controller;

import com.es.spainapi.dto.ProvinciaDTO;
import com.es.spainapi.facade.ProvinciaFacade;
import com.es.spainapi.model.Provincia;
import com.es.spainapi.service.api.ProvinciaServiceAPI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provincias")
public class ProvinciaController {

    private final ProvinciaFacade facade;


    public ProvinciaController(ProvinciaFacade facade) {
        this.facade = facade;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProvinciaDTO>> getAll() {
        return ResponseEntity.ok(facade.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProvinciaDTO> getOne(@PathVariable String id) {
        return ResponseEntity.ok(facade.getOne(id));
    }

    @PostMapping("/")
    public ResponseEntity<ProvinciaDTO> insertOne(@RequestBody ProvinciaDTO dto) {
        return new ResponseEntity<>(facade.insertOne(dto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOne(@PathVariable String id) {
        facade.deleteOne(id);
    }

}
