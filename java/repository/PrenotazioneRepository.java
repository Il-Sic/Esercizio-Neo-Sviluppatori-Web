package repository;

import entity.Prenotazione;
import entity.PrenotazioneId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, PrenotazioneId> {
    
}
