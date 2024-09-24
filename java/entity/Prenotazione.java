package entity;

import javax.persistence.*;

@Entity
@Table(name = "prenotazione")
public class Prenotazione {

    @EmbeddedId
    private PrenotazioneId id;

    @ManyToOne
    @MapsId("prenotanteId") 
    @JoinColumn(name = "id_prenotante")
    private Prenotante prenotante;

    @ManyToOne
    @MapsId("gelatoId")
    @JoinColumn(name = "id_gelato")
    private Gelato gelato;

    

    public Prenotazione() {}

    public Prenotazione(Prenotante prenotante, Gelato gelato) {
        this.prenotante = prenotante;
        this.gelato = gelato;
        this.id = new PrenotazioneId(prenotante.getId(), gelato.getId());
    }

    public PrenotazioneId getId() {
        return id;
    }

    public void setId(PrenotazioneId id) {
        this.id = id;
    }

    public Prenotante getPrenotante() {
        return prenotante;
    }

    public void setPrenotante(Prenotante prenotante) {
        this.prenotante = prenotante;
        this.id.setPrenotanteId(prenotante.getId());
    }

    public Gelato getGelato() {
        return gelato;
    }

    public void setGelato(Gelato gelato) {
        this.gelato = gelato;
        this.id.setGelatoId(gelato.getId());
    }
}
