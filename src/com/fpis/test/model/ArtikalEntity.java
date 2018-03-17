package com.fpis.test.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ARTIKAL", schema = "fpis01", catalog = "fpis01")
public class ArtikalEntity {
    private int sifraartikla;
    private String nazivartikla;
    private String jedinicamere;
    private String opisartikla;
    private int cena;
    private String status;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "SIFRAARTIKLA")
    public int getSifraartikla() {
        return sifraartikla;
    }

    public void setSifraartikla(int sifraartikla) {
        this.sifraartikla = sifraartikla;
    }

    @Basic
    @Column(name = "cena")
    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
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

    @Transient
    public String getStatus() {
        return status;
    }

    @Transient
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtikalEntity that = (ArtikalEntity) o;
        return sifraartikla == that.sifraartikla &&
                Objects.equals(nazivartikla, that.nazivartikla) &&
                Objects.equals(jedinicamere, that.jedinicamere) &&
                Objects.equals(cena, that.cena) &&
                Objects.equals(opisartikla, that.opisartikla);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sifraartikla, nazivartikla, jedinicamere, opisartikla);
    }

}
