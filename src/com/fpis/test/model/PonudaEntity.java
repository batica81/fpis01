package com.fpis.test.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Ponuda", schema = "fpis01", catalog = "")
public class PonudaEntity {
    private int brPonude;
    private Timestamp datum;
    private int sifraKupca;
    private int sifraRadnika;
    private String isporuka;
    private String banka;
    private String tekuciRacun;
    private String uslovi;
    private String napomena;
    private String validnost;
    private String pozivNaBroj;
    private String mesto;
    private Timestamp datumPrometa;
    private String tipPlacanja;
    private String status;
    private Collection<StavkaPonudeEntity> stavkaPonudesByBrPonude;

    @Id
    @Column(name = "BrPonude")
    public int getBrPonude() {
        return brPonude;
    }

    public void setBrPonude(int brPonude) {
        this.brPonude = brPonude;
    }

    @Basic
    @Column(name = "Datum")
    public Timestamp getDatum() {
        return datum;
    }

    public void setDatum(Timestamp datum) {
        this.datum = datum;
    }

    @Basic
    @Column(name = "SifraKupca")
    public int getSifraKupca() {
        return sifraKupca;
    }

    public void setSifraKupca(int sifraKupca) {
        this.sifraKupca = sifraKupca;
    }

    @Basic
    @Column(name = "SifraRadnika")
    public int getSifraRadnika() {
        return sifraRadnika;
    }

    public void setSifraRadnika(int sifraRadnika) {
        this.sifraRadnika = sifraRadnika;
    }

    @Basic
    @Column(name = "Isporuka")
    public String getIsporuka() {
        return isporuka;
    }

    public void setIsporuka(String isporuka) {
        this.isporuka = isporuka;
    }

    @Basic
    @Column(name = "Banka")
    public String getBanka() {
        return banka;
    }

    public void setBanka(String banka) {
        this.banka = banka;
    }

    @Basic
    @Column(name = "TekuciRacun")
    public String getTekuciRacun() {
        return tekuciRacun;
    }

    public void setTekuciRacun(String tekuciRacun) {
        this.tekuciRacun = tekuciRacun;
    }

    @Basic
    @Column(name = "Uslovi")
    public String getUslovi() {
        return uslovi;
    }

    public void setUslovi(String uslovi) {
        this.uslovi = uslovi;
    }

    @Basic
    @Column(name = "Napomena")
    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    @Basic
    @Column(name = "Validnost")
    public String getValidnost() {
        return validnost;
    }

    public void setValidnost(String validnost) {
        this.validnost = validnost;
    }

    @Basic
    @Column(name = "PozivNaBroj")
    public String getPozivNaBroj() {
        return pozivNaBroj;
    }

    public void setPozivNaBroj(String pozivNaBroj) {
        this.pozivNaBroj = pozivNaBroj;
    }

    @Basic
    @Column(name = "Mesto")
    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    @Basic
    @Column(name = "DatumPrometa")
    public Timestamp getDatumPrometa() {
        return datumPrometa;
    }

    public void setDatumPrometa(Timestamp datumPrometa) {
        this.datumPrometa = datumPrometa;
    }

    @Basic
    @Column(name = "TipPlacanja")
    public String getTipPlacanja() {
        return tipPlacanja;
    }

    public void setTipPlacanja(String tipPlacanja) {
        this.tipPlacanja = tipPlacanja;
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
        PonudaEntity that = (PonudaEntity) o;
        return brPonude == that.brPonude &&
                sifraKupca == that.sifraKupca &&
                sifraRadnika == that.sifraRadnika &&
                Objects.equals(datum, that.datum) &&
                Objects.equals(isporuka, that.isporuka) &&
                Objects.equals(banka, that.banka) &&
                Objects.equals(tekuciRacun, that.tekuciRacun) &&
                Objects.equals(uslovi, that.uslovi) &&
                Objects.equals(napomena, that.napomena) &&
                Objects.equals(validnost, that.validnost) &&
                Objects.equals(pozivNaBroj, that.pozivNaBroj) &&
                Objects.equals(mesto, that.mesto) &&
                Objects.equals(datumPrometa, that.datumPrometa) &&
                Objects.equals(tipPlacanja, that.tipPlacanja);
    }

    @Override
    public int hashCode() {

        return Objects.hash(brPonude, datum, sifraKupca, sifraRadnika, isporuka, banka, tekuciRacun, uslovi, napomena, validnost, pozivNaBroj, mesto, datumPrometa, tipPlacanja);
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "ponudaByBrPonude")
    public Collection<StavkaPonudeEntity> getStavkaPonudesByBrPonude() {
        return stavkaPonudesByBrPonude;
    }

    public void setStavkaPonudesByBrPonude(Collection<StavkaPonudeEntity> stavkaPonudesByBrPonude) {
        this.stavkaPonudesByBrPonude = stavkaPonudesByBrPonude;
    }

    public void dodajStavku(int rbr, ArtikalEntity Artikal, int kolicina, String napomenastavke){

        StavkaPonudeEntity sp = new StavkaPonudeEntity();

        sp.setRbr(rbr);
        sp.setBrPonude(brPonude);
        sp.setArtikalBySifraArtikla(Artikal);
        sp.setKolicina(kolicina);
        sp.setNapomenastavke(napomenastavke);
        sp.setStatus("insert");
        sp.setPonudaByBrPonude(this);
        stavkaPonudesByBrPonude.add(sp);
    }

    public void izmeniStavku(int rbr, ArtikalEntity Artikal, int kolicina, String napomenastavke) {

        Collection<StavkaPonudeEntity> stavkePonude = getStavkaPonudesByBrPonude();
        for (Object spRaw:stavkePonude) {

            StavkaPonudeEntity sp = (StavkaPonudeEntity) spRaw;

            if (sp.getRbr() == rbr) {
                sp.setArtikalBySifraArtikla(Artikal);
                sp.setKolicina(kolicina);
                sp.setNapomenastavke(napomenastavke);
                sp.setStatus("update");
            }
        }
    }

    public void obrisiStavku(int rbr){

        Collection<StavkaPonudeEntity> stavkePonude = getStavkaPonudesByBrPonude();
        for (Object spRaw:stavkePonude) {

            StavkaPonudeEntity sp = (StavkaPonudeEntity) spRaw;

            if(sp.getRbr()==rbr) {
                sp.setStatus("delete");
            }
        }
    }

}
