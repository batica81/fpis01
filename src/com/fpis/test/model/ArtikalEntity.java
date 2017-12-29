package com.fpis.test.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "ARTIKAL", schema = "fpis01", catalog = "")
public class ArtikalEntity {
    private int sifraartikla;
    private String nazivartikla;
    private String jedinicamere;
    private String opisartikla;
    private Collection<StavkaPonudeEntity> stavkaPonudesBySifraartikla;

    @Id
    @Column(name = "SIFRAARTIKLA")
    public int getSifraartikla() {
        return sifraartikla;
    }

    public void setSifraartikla(int sifraartikla) {
        this.sifraartikla = sifraartikla;
    }

    @Basic
    @Column(name = "NAZIVARTIKLA")
    public String getNazivartikla() {
        return nazivartikla;
    }

    public void setNazivartikla(String nazivartikla) {
        this.nazivartikla = nazivartikla;
    }

    @Basic
    @Column(name = "JEDINICAMERE")
    public String getJedinicamere() {
        return jedinicamere;
    }

    public void setJedinicamere(String jedinicamere) {
        this.jedinicamere = jedinicamere;
    }

    @Basic
    @Column(name = "OPISARTIKLA")
    public String getOpisartikla() {
        return opisartikla;
    }

    public void setOpisartikla(String opisartikla) {
        this.opisartikla = opisartikla;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtikalEntity that = (ArtikalEntity) o;
        return sifraartikla == that.sifraartikla &&
                Objects.equals(nazivartikla, that.nazivartikla) &&
                Objects.equals(jedinicamere, that.jedinicamere) &&
                Objects.equals(opisartikla, that.opisartikla);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sifraartikla, nazivartikla, jedinicamere, opisartikla);
    }

    @OneToMany(mappedBy = "artikalBySifraArtikla")
    public Collection<StavkaPonudeEntity> getStavkaPonudesBySifraartikla() {
        return stavkaPonudesBySifraartikla;
    }

    public void setStavkaPonudesBySifraartikla(Collection<StavkaPonudeEntity> stavkaPonudesBySifraartikla) {
        this.stavkaPonudesBySifraartikla = stavkaPonudesBySifraartikla;
    }
}
