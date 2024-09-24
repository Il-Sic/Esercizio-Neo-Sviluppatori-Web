package entity;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="gelato")
public class Gelato {
	
	@Column(name = "id")
	@Id
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "descrizione")
	private String descrizione;
	
	 @ManyToMany(mappedBy = "gelati") 
	 private Set<Prenotante> prenotanti = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	

}
