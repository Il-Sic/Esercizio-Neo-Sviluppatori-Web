package com.gelateria.app1.service;

import com.gelateria.app1.entity.Prenotante;
import org.springframework.beans.factory.annotation.Autowired;
import com.gelateria.app1.repository.PrenotanteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrenotanteService
{

    @Autowired
    private PrenotanteRepository prenotanteRepository;

    //Metodo per salavare un prenotante
    public Prenotante savePrenotante(Prenotante prenotante)
    {
        return prenotanteRepository.save(prenotante);

    }

    //Metodo per recuperare tutti i prenotanti
    public List<Prenotante> getAllPrenotanti()
    {
        return prenotanteRepository.findAll();
    }

    //Metodo per recuperare un prenotante per id
    public Optional<Prenotante> getPrenotanteById(Integer id)
    {
        return prenotanteRepository.findById(id);

    }

    //Metodo per aggiornare un prenotante
    public Prenotante updatePrenotante(Prenotante prenotante)
    {
        if (prenotanteRepository.existsById(prenotante.getIdPrenotante()))
        {
            return prenotanteRepository.save(prenotante);
        } else
        {
            return null;
        }
    }

    //Metodo per eliminare un prenotante
    public void deletePrenotante(Integer id)
    {
        prenotanteRepository.deleteById(id);
    }

}
