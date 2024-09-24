package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.Prenotante;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import service.PrenotanteService;

@RestController
@RequestMapping("/prenotanti")
public class PrenotanteController {
	
	@Autowired
	private PrenotanteService prenotanteService;
	
	@GetMapping 
	public ResponseEntity<List<Prenotante>> getAllPrenotanti(){
		List<Prenotante> prenotante = prenotanteService.getAllPrenotante();
		return new ResponseEntity<>(prenotante, HttpStatus.OK);
	}
	
	@GetMapping ("{id}")
	public ResponseEntity<Prenotante> getPrenotanteById(@PathVariable Integer id) {
		Optional <Prenotante> prenotante = prenotanteService.getPrenotanteById(id);
		return prenotante.map(value-> new ResponseEntity<>(value,HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
	}
	
	@PostMapping
	public ResponseEntity<Prenotante> savePrenotante(@RequestBody Prenotante prenotante){
		Prenotante savedPrenotante = prenotanteService.savePrenotante(prenotante);
		return new ResponseEntity<>(savedPrenotante, HttpStatus.CREATED);
	}
	
	@PutMapping ("{id}")
	public ResponseEntity<Prenotante> updatePrenotante(@PathVariable Integer id, @RequestBody Prenotante prenotante){
		prenotante.setId(id);
		Prenotante updatedPrenotante = prenotanteService.updatePrenotante(prenotante);
		return updatedPrenotante != null ?
				new ResponseEntity<>(updatedPrenotante, HttpStatus.OK) :
					new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletePrenotante(@PathVariable Integer id){
		prenotanteService.deletePrenotante(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
