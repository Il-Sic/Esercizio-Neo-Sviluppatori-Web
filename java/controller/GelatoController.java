package controller;

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

import service.GelatoService;

import entity.Gelato;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gelati")
public class GelatoController {
	
	@Autowired
	private GelatoService gelatoService;
	
	@GetMapping 
	public ResponseEntity<List<Gelato>> getAllGelati(){
		List<Gelato> gelato = gelatoService.getAllGelato();
		return new ResponseEntity<>(gelato, HttpStatus.OK);
	}
	
	@GetMapping ("{id}")
	public ResponseEntity<Gelato> getGelatoById(@PathVariable Long id) {
		Optional <Gelato> gelato = gelatoService.getGelatoById(id);
		return gelato.map(value-> new ResponseEntity<>(value,HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
	}
	
	@PostMapping
	public ResponseEntity<Gelato> saveGelato(@RequestBody Gelato gelato){
		Gelato savedGelato = gelatoService.saveGelato(gelato);
		return new ResponseEntity<>(savedGelato, HttpStatus.CREATED);
	}
	
	@PutMapping ("{id}")
	public ResponseEntity<Gelato> updateGelato(@PathVariable Long id, @RequestBody Gelato gelato){
		gelato.setId(id);
		Gelato updatedGelato = gelatoService.updateGelato(gelato);
		return updatedGelato != null ?
				new ResponseEntity<>(updatedGelato, HttpStatus.OK) :
					new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteGelato(@PathVariable Long id){
		gelatoService.deleteGelato(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
