package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Gelato;
import repository.GelatoRepository;

@Service
public class GelatoService {
	
	@Autowired
	private GelatoRepository gelatoRepository;
	
	//metodo per salvare un gelato
	
	public Gelato saveGelato(Gelato gelato) {
		return gelatoRepository.save(gelato);
	}
	
	//Metodo per recuperare tutti i gelati
	
	public List<Gelato> getAllGelato(){
		return gelatoRepository.findAll();
	}
	
	//Metodo per recuperare gelato per id
	
	public Optional<Gelato> getGelatoById(Long id){
		return  gelatoRepository.findById(id);
		
	}
	
	//Metodo per aggiornare un gelato
	
	public Gelato updateGelato(Gelato gelato) {
		if(gelatoRepository.existsById(gelato.getId())) {
			return gelatoRepository.save(gelato);
		}else {
			return null;
		}
		
	}
	
	//Metodo per eliminare un paziente per Id
	
	public void deleteGelato(Long id) {
		gelatoRepository.deleteById(id);
	}
	
	
}
