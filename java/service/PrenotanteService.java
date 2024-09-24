package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Prenotante;
import repository.PrenotanteRepository;

@Service
public class PrenotanteService {
	@Autowired
	private PrenotanteRepository prenotanteRepository;
	
	//metodo per salvare un gelato
	
	public Prenotante savePrenotante(Prenotante prenotante) {
		return prenotanteRepository.save(prenotante);
	}
	
	//Metodo per recuperare tutti i gelati
	
	public List<Prenotante> getAllPrenotante(){
		return prenotanteRepository.findAll();
	}
	
	//Metodo per recuperare gelato per id
	
	public Optional<Prenotante> getPrenotanteById(Integer id){
		return  prenotanteRepository.findById(id);
		
	}
	
	//Metodo per aggiornare un gelato
	
	public Prenotante updatePrenotante(Prenotante prenotante) {
		if(prenotanteRepository.existsById(prenotante.getId())) {
			return prenotanteRepository.save(prenotante);
		}else {
			return null;
		}
		
	}
	
	//Metodo per eliminare un paziente per Id
	
	public void deletePrenotante(Integer id) {
		prenotanteRepository.deleteById(id);
	}
	
	
}



