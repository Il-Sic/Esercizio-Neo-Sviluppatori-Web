package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.*;

import entity.Gelato;

public interface GelatoRepository  extends JpaRepository <Gelato, Long>{
	List<Gelato> findAll();
	Optional<Gelato> findById(Long id);
	
	

}



