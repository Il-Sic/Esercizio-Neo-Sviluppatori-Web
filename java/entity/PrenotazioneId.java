package entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PrenotazioneId implements Serializable {

    private Integer prenotanteId;
    private Long gelatoId;

    public PrenotazioneId() {}

    public PrenotazioneId(Integer prenotanteId, Long gelatoId) {
        this.prenotanteId = prenotanteId;
        this.gelatoId = gelatoId;
    }

    public Integer getPrenotanteId() {
        return prenotanteId;
    }

    public void setPrenotanteId(Integer prenotanteId) {
        this.prenotanteId = prenotanteId;
    }

    public Long getGelatoId() {
        return gelatoId;
    }

    public void setGelatoId(Long gelatoId) {
        this.gelatoId = gelatoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PrenotazioneId)) return false;
        PrenotazioneId that = (PrenotazioneId) o;
        return Objects.equals(prenotanteId, that.prenotanteId) && Objects.equals(gelatoId, that.gelatoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prenotanteId, gelatoId);
    }
}
