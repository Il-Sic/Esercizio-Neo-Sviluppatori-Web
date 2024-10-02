package com.gelateria.app1.repository;

import com.gelateria.app1.entity.Prenotazione;
import com.gelateria.app1.entity.PrenotazioneId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrenotazioneRepository extends JpaRepository <Prenotazione, PrenotazioneId>
{

}
