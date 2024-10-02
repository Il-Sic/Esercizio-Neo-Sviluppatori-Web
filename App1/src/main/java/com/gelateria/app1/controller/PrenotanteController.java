package com.gelateria.app1.controller;

import com.gelateria.app1.entity.Prenotante;
import io.swagger.v3.oas.annotations.Parameter;
import org.openapitools.api.GelateriaApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import com.gelateria.app1.service.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gelateria/prenotanti")
public class PrenotanteController implements GelateriaApi
{

    @Autowired
    private PrenotanteService prenotanteService;

    //implemento GET
    @GetMapping
    public ResponseEntity<List<Prenotante>> apiPrenotanteGet()
    {
        List<Prenotante> prenotante = prenotanteService.getAllPrenotanti();
        return new ResponseEntity<>(prenotante, HttpStatus.OK);

    }

    //implemento GET by Id
    @GetMapping("/{id}")
    public ResponseEntity<Prenotante> apiPrenotanteIdPrenotanteGet(@PathVariable Integer id)
    {
        Optional<Prenotante> prenotante = prenotanteService.getPrenotanteById(id);
        return prenotante.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    //implemento Post
    @PostMapping
    public ResponseEntity<Prenotante> apiPrenotantePost(
            @Parameter(name = "Prenotante", description = "", required = true) @Valid @RequestBody Prenotante prenotante
    )
    {
        Prenotante savedPrenotante = prenotanteService.savePrenotante(prenotante);
        return new ResponseEntity<>(savedPrenotante, HttpStatus.CREATED);
    }

    //implemento Put by id
    @PutMapping("/{id}")
    public ResponseEntity<Prenotante> apiPrenotanteIdPrenotantePut(
            @PathVariable("id") Integer idPrenotante, @RequestBody Prenotante prenotante
    )
    {
        prenotante.setIdPrenotante(idPrenotante);
        Prenotante updatedPrenotante = prenotanteService.updatePrenotante(prenotante);
        return updatedPrenotante != null ?
                new ResponseEntity<>(updatedPrenotante, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    //implemento Delete by Id
    @DeleteMapping("/{id}")
    public ResponseEntity<Prenotante> apiPrenotanteIdPrenotanteDelete(
            @PathVariable("id") Integer idPrenotante)
    {
        prenotanteService.deletePrenotante(idPrenotante);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}

