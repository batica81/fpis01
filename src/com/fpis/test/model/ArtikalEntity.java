package com.fpis.test.model;

import javax.persistence.*;

@Entity
@Table(name = "ARTIKAL", schema = "FPIS01", catalog = "")
public class ArtikalEntity {
    private long sifraartikla;
    private String nazivartikla;
    private String jedinicamere;
    private String opisartikla;

    @Id
    @Column(name = "SIFRAARTIKLA", nullable = false, precision = 0)
    public long getSifraartikla() {
        return sifraartikla;
    }

    public void setSifraartikla(long sifraartikla) {
        this.sifraartikla = sifraartikla;
    }

    @Basic
    @Column(name = "NAZIVARTIKLA", nullable = false, length = 200)
    public String getNazivartikla() {
        return nazivartikla;
    }

    public void setNazivartikla(String nazivartikla) {
        this.nazivartikla = nazivartikla;
    }

    @Basic
    @Column(name = "JEDINICAMERE", nullable = true, length = 20)
    public String getJedinicamere() {
        return jedinicamere;
    }

    public void setJedinicamere(String jedinicamere) {
        this.jedinicamere = jedinicamere;
    }

    @Basic
    @Column(name = "OPISARTIKLA", nullable = true, length = 200)
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

        if (sifraartikla != that.sifraartikla) return false;
        if (nazivartikla != null ? !nazivartikla.equals(that.nazivartikla) : that.nazivartikla != null) return false;
        if (jedinicamere != null ? !jedinicamere.equals(that.jedinicamere) : that.jedinicamere != null) return false;
        if (opisartikla != null ? !opisartikla.equals(that.opisartikla) : that.opisartikla != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (sifraartikla ^ (sifraartikla >>> 32));
        result = 31 * result + (nazivartikla != null ? nazivartikla.hashCode() : 0);
        result = 31 * result + (jedinicamere != null ? jedinicamere.hashCode() : 0);
        result = 31 * result + (opisartikla != null ? opisartikla.hashCode() : 0);
        return result;
    }
}
