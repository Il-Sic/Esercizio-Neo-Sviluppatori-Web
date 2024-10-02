package com.gelateria.app1.controller;

import com.gelateria.app1.repository.*;
import com.gelateria.app1.entity.Prenotazione;

import org.openapitools.api.GelateriaApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gelateria/prenotazioni")
public class PrenotazioneController implements GelateriaApi
{
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @GetMapping
    public List<Prenotazione> getAllPrenotazioni()
    {
        return prenotazioneRepository.findAll();
    }

    @PostMapping
    public Prenotazione createPrenotazione(@RequestBody Prenotazione prenotazione)
    {
        return prenotazioneRepository.save(prenotazione);
    }
}
