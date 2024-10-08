package com.gelateria.app1.controller;

import com.gelateria.app1.entity.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import org.openapitools.api.GelateriaApi;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import com.gelateria.app1.service.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gelateria/gelati")
public class GelatoController implements GelateriaApi
{

    @Autowired
    private GelatoService gelatoService;


    //implemento GET
    @GetMapping
    public ResponseEntity<List<Gelato>> apiGelatiGet(){
        List<Gelato> gelato = gelatoService.getAllGelati();
        return new ResponseEntity<>(gelato, HttpStatus.OK);

    }

    //Get by Id
    @GetMapping("/{id}")
    public ResponseEntity<Gelato> apiGelatiIdGet(@PathVariable Integer id){
        Optional<Gelato> gelato = gelatoService.getGelatoById(id);
        return gelato.map(value-> new ResponseEntity<>(value,HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    //Post
    @PostMapping
    public ResponseEntity<Gelato> apiGelatiPost(@Parameter(name="Gelato", description = "", required = true)
                                                @Valid @RequestBody Gelato gelato){
        Gelato savedGelato = gelatoService.saveGelato(gelato);
        return new ResponseEntity<>(savedGelato, HttpStatus.CREATED);

    }

    //Put by Id
    @PutMapping("/{id}")
    public ResponseEntity<Gelato> apiGelatiIdPut(@Parameter(name = "id", description = "ID del gelato da aggiornare", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id,
                                                 @Parameter(name = "Gelato", description = "", required = true) @Valid @RequestBody Gelato gelato)
    {
        gelato.setId(id);
        Gelato updatedGelato = gelatoService.updateGelato(gelato);
        return updatedGelato != null ?
                new ResponseEntity<>(updatedGelato, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    //Delete by Id
    @DeleteMapping("/{idGelato}")
    public ResponseEntity<Gelato> apiGelatiIdDelete(
            @PathVariable ("idGelato") Integer id
    ) {
        gelatoService.deleteGelato (id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
