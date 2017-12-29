package com.fpis.test.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "StavkaPonude", schema = "fpis01", catalog = "")
@IdClass(StavkaPonudeEntityPK.class)
public class StavkaPonudeEntity {
    private int rbr;
    private int brPonude;
    private int kolicina;
    private PonudaEntity ponudaByBrPonude;
    private ArtikalEntity artikalBySifraArtikla;

    @Id
    @Column(name = "Rbr")
    public int getRbr() {
        return rbr;
    }

    public void setRbr(int rbr) {
        this.rbr = rbr;
    }

    @Id
    @Column(name = "BrPonude")
    public int getBrPonude() {
        return brPonude;
    }

    public void setBrPonude(int brPonude) {
        this.brPonude = brPonude;
    }

    @Basic
    @Column(name = "Kolicina")
    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StavkaPonudeEntity that = (StavkaPonudeEntity) o;
        return rbr == that.rbr &&
                brPonude == that.brPonude &&
                kolicina == that.kolicina;
    }

    @Override
    public int hashCode() {

        return Objects.hash(rbr, brPonude, kolicina);
    }

    @ManyToOne
    @JoinColumn(name = "BrPonude", referencedColumnName = "BrPonude", nullable = false, insertable = false, updatable = false)
    public PonudaEntity getPonudaByBrPonude() {
        return ponudaByBrPonude;
    }

    public void setPonudaByBrPonude(PonudaEntity ponudaByBrPonude) {
        this.ponudaByBrPonude = ponudaByBrPonude;
    }

    @ManyToOne
    @JoinColumn(name = "SifraArtikla", referencedColumnName = "SIFRAARTIKLA", nullable = false)
    public ArtikalEntity getArtikalBySifraArtikla() {
        return artikalBySifraArtikla;
    }

    public void setArtikalBySifraArtikla(ArtikalEntity artikalBySifraArtikla) {
        this.artikalBySifraArtikla = artikalBySifraArtikla;
    }
}
