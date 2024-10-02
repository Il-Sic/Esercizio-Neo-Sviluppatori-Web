package com.gelateria.app1.entity;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.*;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.Generated;

@Entity
@Table(name = "prenotazione")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-02T13:27:07.715890+02:00[Europe/Rome]")
public class Prenotazione
{
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

    @JsonProperty("id_prenotante")
    private Integer idPrenotante;

    @JsonProperty("id_gelato")
    private Integer idGelato;

    public Prenotazione idPrenotante(Integer idPrenotante)
    {
        this.idPrenotante = idPrenotante;
        return this;
    }

    public PrenotazioneId getId()
    {
        return id;
    }

    public void setId(PrenotazioneId id)
    {
        this.id = id;
    }

    public Prenotante getPrenotante()
    {
        return prenotante;
    }

    public void setPrenotante(Prenotante prenotante)
    {
        this.prenotante = prenotante;
    }

    public Gelato getGelato()
    {
        return gelato;
    }

    public void setGelato(Gelato gelato)
    {
        this.gelato = gelato;
    }

    /**
     * ID del prenotante
     *
     * @return idPrenotante
     */
    @NotNull
    @Schema(name = "id_prenotante", description = "ID del prenotante", required = true)
    public Integer getIdPrenotante()
    {
        return idPrenotante;
    }

    public void setIdPrenotante(Integer idPrenotante)
    {
        this.idPrenotante = idPrenotante;
    }

    public Prenotazione idGelato(Integer idGelato)
    {
        this.idGelato = idGelato;
        return this;
    }

    /**
     * ID del gelato
     *
     * @return idGelato
     */
    @NotNull
    @Schema(name = "id_gelato", description = "ID del gelato", required = true)
    public Integer getIdGelato()
    {
        return idGelato;
    }

    public void setIdGelato(Integer idGelato)
    {
        this.idGelato = idGelato;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        org.openapitools.model.Prenotazione prenotazione = (org.openapitools.model.Prenotazione) o;
        return Objects.equals(this.idPrenotante, prenotazione.getIdPrenotante()) &&
                Objects.equals(this.idGelato, prenotazione.getIdGelato());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(idPrenotante, idGelato);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class Prenotazione {\n");
        sb.append("    idPrenotante: ").append(toIndentedString(idPrenotante)).append("\n");
        sb.append("    idGelato: ").append(toIndentedString(idGelato)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o)
    {
        if (o == null)
        {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }


}