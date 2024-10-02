package com.gelateria.app1.entity;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.*;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.Generated;
import javax.persistence.Entity;

@Entity
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-02T13:27:07.715890+02:00[Europe/Rome]")
public class Gelato
{

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("descrizione")
    private String descrizione;

    public Gelato id(Integer id)
    {
        this.id = id;
        return this;
    }

    /**
     * ID univoco del gelato
     *
     * @return id
     */
    @NotNull
    @Schema(name = "id", description = "ID univoco del gelato", required = true)
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Gelato nome(String nome)
    {
        this.nome = nome;
        return this;
    }

    /**
     * Nome del gusto di gelato
     *
     * @return nome
     */
    @NotNull
    @Schema(name = "nome", description = "Nome del gusto di gelato", required = true)
    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public Gelato descrizione(String descrizione)
    {
        this.descrizione = descrizione;
        return this;
    }

    /**
     * Descrizione del gelato
     *
     * @return descrizione
     */
    @NotNull
    @Schema(name = "descrizione", example = "Gelato al cioccolato realizzato con ingredienti di alta qualità.", description = "Descrizione del gelato", required = true)
    public String getDescrizione()
    {
        return descrizione;
    }

    public void setDescrizione(String descrizione)
    {
        this.descrizione = descrizione;
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
        org.openapitools.model.Gelato gelato = (org.openapitools.model.Gelato) o;
        return Objects.equals(this.id, gelato.getId()) &&
                Objects.equals(this.nome, gelato.getNome()) &&
                Objects.equals(this.descrizione, gelato.getDescrizione());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, nome, descrizione);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class Gelato {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
        sb.append("    descrizione: ").append(toIndentedString(descrizione)).append("\n");
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


