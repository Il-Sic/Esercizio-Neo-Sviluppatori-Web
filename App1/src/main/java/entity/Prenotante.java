package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "prenotante")
public class Prenotante {
	
	@Column(name="id")
	@Id
	private int id;
	
	@Column(name="nome")
	private String nome;
	
	@ManyToMany
    @JoinTable(
        name = "prenotazione",
        joinColumns = @JoinColumn(name = "id_prenotante"),
        inverseJoinColumns = @JoinColumn(name = "id_gelato")
    )
	private Set<Gelato> gelati = new HashSet<>();
   

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	

}
