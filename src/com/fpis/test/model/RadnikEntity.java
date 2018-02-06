package com.fpis.test.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Radnik", schema = "fpis01", catalog = "")
public class RadnikEntity {
    private int sifraRadnika;
    private String ime;
    private String adresa;
    private int matBr;
    private int brTel;
    private String email;
    private int brLk;

    @Id
    @Column(name = "SifraRadnika")
    public int getSifraRadnika() {
        return sifraRadnika;
    }

    public void setSifraRadnika(int sifraRadnika) {
        this.sifraRadnika = sifraRadnika;
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
    @Column(name = "MatBr")
    public int getMatBr() {
        return matBr;
    }

    public void setMatBr(int matBr) {
        this.matBr = matBr;
    }

    @Basic
    @Column(name = "BrTel")
    public int getBrTel() {
        return brTel;
    }

    public void setBrTel(int brTel) {
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

    @Basic
    @Column(name = "BrLk")
    public int getBrLk() {
        return brLk;
    }

    public void setBrLk(int brLk) {
        this.brLk = brLk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RadnikEntity that = (RadnikEntity) o;
        return sifraRadnika == that.sifraRadnika &&
                matBr == that.matBr &&
                brTel == that.brTel &&
                brLk == that.brLk &&
                Objects.equals(ime, that.ime) &&
                Objects.equals(adresa, that.adresa) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sifraRadnika, ime, adresa, matBr, brTel, email, brLk);
    }
}
