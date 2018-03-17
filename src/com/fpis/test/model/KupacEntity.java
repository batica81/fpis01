package com.fpis.test.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Kupac", schema = "fpis01", catalog = "fpis01")
public class KupacEntity {
    private int sifraKupca;
    private String ime;
    private String adresa;
    private Integer pib;
    private Integer brTel;
    private String email;

    @Id
    @Column(name = "SifraKupca")
    public int getSifraKupca() {
        return sifraKupca;
    }

    public void setSifraKupca(int sifraKupca) {
        this.sifraKupca = sifraKupca;
    }

    @Basic
    @Column(name = "Ime")
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    @Basic
    @Column(name = "Adresa")
    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Basic
    @Column(name = "PIB")
    public Integer getPib() {
        return pib;
    }

    public void setPib(Integer pib) {
        this.pib = pib;
    }

    @Basic
    @Column(name = "BrTel")
    public Integer getBrTel() {
        return brTel;
    }

    public void setBrTel(Integer brTel) {
        this.brTel = brTel;
    }

    @Basic
    @Column(name = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KupacEntity that = (KupacEntity) o;
        return sifraKupca == that.sifraKupca &&
                Objects.equals(ime, that.ime) &&
                Objects.equals(adresa, that.adresa) &&
                Objects.equals(pib, that.pib) &&
                Objects.equals(brTel, that.brTel) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sifraKupca, ime, adresa, pib, brTel, email);
    }
}
