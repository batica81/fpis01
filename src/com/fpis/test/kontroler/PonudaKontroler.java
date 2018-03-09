package com.fpis.test.kontroler;

import com.fpis.test.dbbroker.DBbroker;
import com.fpis.test.model.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@WebServlet(name = "PonudaKontroler", urlPatterns = {"/ponudakontroler"})
public class PonudaKontroler extends HttpServlet {
    private List<PonudaEntity> listaPonuda;
    private List<ArtikalEntity> listaArtikala;
    private List<KupacEntity> listaKupaca;
    private List<RadnikEntity> listaRadnika;
    private boolean ret;
    private DBbroker dbb = new DBbroker();
    private PonudaEntity p = new PonudaEntity();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println(pronadjiPonudu(Integer.valueOf(request.getParameter("brPonude"))));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            if (request.getParameterMap().containsKey("radsastavkom")) {

                String status = String.valueOf(request.getParameter("status"));

                if (status.equals("insert")) {
                    int kolicina = Integer.valueOf(request.getParameter("KOLICINA"));
                    int rbr = dodajRbr();
                    int sifraartikla = Integer.valueOf(request.getParameter("SIFRAARTIKLA"));
                    String napomenastavke = String.valueOf(request.getParameter("napomenastavke"));
                    dodajStavku(rbr, sifraartikla, kolicina, napomenastavke);
                } else if (status.equals("update")) {
                    int kolicina = Integer.valueOf(request.getParameter("KOLICINA"));
                    int rbr = Integer.valueOf(request.getParameter("rbr"));
                    int sifraartikla = Integer.valueOf(request.getParameter("SIFRAARTIKLA"));
                    String napomenastavke = String.valueOf(request.getParameter("napomenastavke"));
                    izmeniStavku(rbr, sifraartikla, kolicina, napomenastavke);
                } else if (status.equals("delete")) {
                    int rbr = Integer.valueOf(request.getParameter("rbr"));
                    obrisiStavku(rbr);
                }
            } else {


            String status = String.valueOf(request.getParameter("status"));
            Timestamp datum = Timestamp.valueOf(request.getParameter("datum"));
            int sifraKupca = Integer.valueOf(request.getParameter("sifraKupca"));
            int sifraRadnika = Integer.valueOf(request.getParameter("sifraRadnika"));
            String isporuka = String.valueOf(request.getParameter("isporuka"));
            String banka = String.valueOf(request.getParameter("banka"));
            String tekuciRacun = String.valueOf(request.getParameter("tekuciRacun"));
            String uslovi = String.valueOf(request.getParameter("uslovi"));
            String napomena = String.valueOf(request.getParameter("napomena"));
            String validnost = String.valueOf(request.getParameter("validnost"));
            String pozivNaBroj = String.valueOf(request.getParameter("pozivNaBroj"));
            String mesto = String.valueOf(request.getParameter("mesto"));
            Timestamp datumPrometa = Timestamp.valueOf(request.getParameter("datumPrometa"));
            String tipPlacanja = String.valueOf(request.getParameter("tipPlacanja"));

            //todo: redosled upisa za novu ponudu sa stavkom !!!

            if (status.equals("insert")) {
                dodajPonudu(0, datum, sifraKupca, sifraRadnika, isporuka, banka, tekuciRacun, uslovi, napomena, validnost,
                        pozivNaBroj, mesto, datumPrometa, tipPlacanja);
            } else if (status.equals("update")) {
                izmeniPonudu(p.getBrPonude(), datum, sifraKupca, sifraRadnika, isporuka, banka, tekuciRacun, uslovi, napomena, validnost,
                        pozivNaBroj, mesto, datumPrometa, tipPlacanja);
            } else if (status.equals("delete")) {
                obrisiPonudu(p.getBrPonude());
            }

            response.setContentType("text/html");
            RequestDispatcher view = request.getRequestDispatcher("html/back.html");
            view.forward(request, response);

        }
    } //end doPost

    public String vratiPonude(){
        dbb.pokreniDBTransakciju();
        listaPonuda = dbb.vratiPonude();
        JSONArray listaPonudaJSON = new JSONArray();

        for (Object ponudaRaw:listaPonuda) {
            PonudaEntity ponuda = (PonudaEntity) ponudaRaw;
            JSONObject ponudaJson = new JSONObject();
            JSONArray listaStavkiJson = new JSONArray();
            Collection<StavkaPonudeEntity> stavkePonude = ponuda.getKolekcijaStavki();

            for (Object stavkaRaw:stavkePonude) {
                JSONObject stavkaJson = new JSONObject();
                StavkaPonudeEntity sp = (StavkaPonudeEntity) stavkaRaw;
                stavkaJson.put("Rbr", sp.getRbr());
                stavkaJson.put("Kolicina", sp.getKolicina());
                stavkaJson.put("Artikal", sp.getArtikalBySifraArtikla().getNazivartikla());
                stavkaJson.put("Napomena", sp.getNapomenastavke());
                listaStavkiJson.add(stavkaJson);
            }

            ponudaJson.put("BrPonude", ponuda.getBrPonude());
            ponudaJson.put("datum", ponuda.getDatum().toString());
            ponudaJson.put("sifraKupca", ponuda.getSifraKupca());
            ponudaJson.put("sifraRadnika", ponuda.getSifraRadnika());
            ponudaJson.put("isporuka", ponuda.getIsporuka());
            ponudaJson.put("banka", ponuda.getBanka());
            ponudaJson.put("tekuciRacun", ponuda.getTekuciRacun());
            ponudaJson.put("uslovi", ponuda.getUslovi());
            ponudaJson.put("napomena", ponuda.getNapomena());
            ponudaJson.put("validnost", ponuda.getValidnost());
            ponudaJson.put("pozivNaBroj", ponuda.getPozivNaBroj());
            ponudaJson.put("mesto", ponuda.getMesto());
            ponudaJson.put("datumPrometa", ponuda.getDatumPrometa().toString());
            ponudaJson.put("tipPlacanja", ponuda.getTipPlacanja());
            ponudaJson.put("Stavke", listaStavkiJson);
            listaPonudaJSON.add(ponudaJson);
        }
        return String.valueOf(listaPonudaJSON);
    }

    public String vratiArtikle(){
        dbb.pokreniDBTransakciju();
        listaArtikala  = dbb.vratiArtikle();
        dbb.potvrdiDBTransakciju();
        JSONArray arr = new JSONArray();
        for (Object artikalRaw:listaArtikala) {
            JSONObject obj = new JSONObject();
            ArtikalEntity artikal = (ArtikalEntity) artikalRaw;
            obj.put("jedinicamere", artikal.getJedinicamere());
            obj.put("opisartikla", artikal.getOpisartikla());
            obj.put("nazivartikla", artikal.getNazivartikla());
            obj.put("sifraartikla", artikal.getSifraartikla());
            obj.put("cena", artikal.getCena());
            arr.add(obj);
        }
        return String.valueOf(arr);
    }

    public String vratiRadnike(){
        dbb.pokreniDBTransakciju();
        listaRadnika = dbb.vratiRadnike();
        dbb.potvrdiDBTransakciju();
        JSONArray arr = new JSONArray();
        for (Object radnikRaw:listaRadnika) {
            JSONObject obj = new JSONObject();
            RadnikEntity radnik = (RadnikEntity) radnikRaw;
            obj.put("ime", radnik.getIme());
            obj.put("sifraRadnika", radnik.getSifraRadnika());
            arr.add(obj);
        }
        return String.valueOf(arr);
    }

    public String vratiKupce(){
        dbb.pokreniDBTransakciju();
        listaKupaca = dbb.vratiKupce();
        dbb.potvrdiDBTransakciju();
        JSONArray arr = new JSONArray();
        for (Object kupacRaw:listaKupaca) {
            JSONObject obj = new JSONObject();
            KupacEntity kupac = (KupacEntity) kupacRaw;
            obj.put("ime", kupac.getIme());
            obj.put("sifraKupca", kupac.getSifraKupca());
            arr.add(obj);
        }
        return String.valueOf(arr);
    }

    public void dodajPonudu(int brPonude, Timestamp datum, int sifraKupca, int sifraRadnika, String isporuka, String banka, String tekuciRacun, String uslovi, String napomena, String validnost, String pozivNaBroj, String mesto, Timestamp datumPrometa, String tipPlacanja){
        p.setBrPonude(brPonude);
        p.setDatum(datum);
        p.setSifraKupca(sifraKupca);
        p.setSifraRadnika(sifraRadnika);
        p.setIsporuka(isporuka);
        p.setBanka(banka);
        p.setTekuciRacun(tekuciRacun);
        p.setUslovi(uslovi);
        p.setNapomena(napomena);
        p.setValidnost(validnost);
        p.setPozivNaBroj(pozivNaBroj);
        p.setMesto(mesto);
        p.setDatumPrometa(datumPrometa);
        p.setTipPlacanja(tipPlacanja);
        p.setStatus("insert");

        dbb.pokreniDBTransakciju();
        ret = dbb.zapamtiPonudu(p);
        if(ret)
            dbb.potvrdiDBTransakciju();
        else
            dbb.ponistiDBTransakciju();
    }

    public void izmeniPonudu(int brPonude, Timestamp datum, int sifraKupca, int sifraRadnika, String isporuka, String banka, String tekuciRacun, String uslovi, String napomena, String validnost, String pozivNaBroj, String mesto, Timestamp datumPrometa, String tipPlacanja){
        p.setBrPonude(brPonude);
        p.setDatum(datum);
        p.setSifraKupca(sifraKupca);
        p.setSifraRadnika(sifraRadnika);
        p.setIsporuka(isporuka);
        p.setBanka(banka);
        p.setTekuciRacun(tekuciRacun);
        p.setUslovi(uslovi);
        p.setNapomena(napomena);
        p.setValidnost(validnost);
        p.setPozivNaBroj(pozivNaBroj);
        p.setMesto(mesto);
        p.setDatumPrometa(datumPrometa);
        p.setTipPlacanja(tipPlacanja);
        p.setStatus("update");

        dbb.pokreniDBTransakciju();
        ret = dbb.zapamtiPonudu(p);
        if(ret) {
            dbb.potvrdiDBTransakciju();
            }
        else
            dbb.ponistiDBTransakciju();
    }

    public void obrisiPonudu(int brPonude){
        p.setBrPonude(brPonude);
        p.setStatus("delete");

        dbb.pokreniDBTransakciju();
        ret = dbb.zapamtiPonudu(p);
        if(ret)
            dbb.potvrdiDBTransakciju();
        else
            dbb.ponistiDBTransakciju();
    }

    public String pronadjiPonudu(int brPonude) {
        dbb.pokreniDBTransakciju();
        p = dbb.pronadjiPonudu(brPonude);
        dbb.potvrdiDBTransakciju();
        JSONObject ponudaJson = new JSONObject();
        JSONArray listaStavkiJson = new JSONArray();
        Collection<StavkaPonudeEntity> stavkePonude = p.getKolekcijaStavki();

        for (Object stavkaRaw:stavkePonude) {
            JSONObject stavkaJson = new JSONObject();
            StavkaPonudeEntity sp = (StavkaPonudeEntity) stavkaRaw;
            stavkaJson.put("Rbr", sp.getRbr());
            stavkaJson.put("Kolicina", sp.getKolicina());
            stavkaJson.put("Artikal", sp.getArtikalBySifraArtikla().getNazivartikla());
            stavkaJson.put("Napomena", sp.getNapomenastavke());
            listaStavkiJson.add(stavkaJson);
        }

        ponudaJson.put("BrPonude", p.getBrPonude());
        ponudaJson.put("datum", p.getDatum().toString());
        ponudaJson.put("sifraKupca", p.getSifraKupca());
        ponudaJson.put("sifraRadnika", p.getSifraRadnika());
        ponudaJson.put("isporuka", p.getIsporuka());
        ponudaJson.put("banka", p.getBanka());
        ponudaJson.put("tekuciRacun", p.getTekuciRacun());
        ponudaJson.put("uslovi", p.getUslovi());
        ponudaJson.put("napomena", p.getNapomena());
        ponudaJson.put("validnost", p.getValidnost());
        ponudaJson.put("pozivNaBroj", p.getPozivNaBroj());
        ponudaJson.put("mesto", p.getMesto());
        ponudaJson.put("datumPrometa", p.getDatumPrometa().toString());
        ponudaJson.put("tipPlacanja", p.getTipPlacanja());
        ponudaJson.put("Stavke", listaStavkiJson);
        return String.valueOf(ponudaJson);
    }

    public void dodajStavku(int rbr, int sifraartikla, int kolicina, String napomenastavke){
        vratiArtikle();
        ArtikalEntity odabraniArtikal = new ArtikalEntity();
        for (Object artikalRaw:listaArtikala) {
            ArtikalEntity Artikal = (ArtikalEntity) artikalRaw;
            if (sifraartikla == Artikal.getSifraartikla()) {
                odabraniArtikal = Artikal;
            }
        }
        p.dodajStavku(rbr, odabraniArtikal, kolicina, napomenastavke);
    }

    public void izmeniStavku(int rbr, int sifraartikla, int kolicina, String napomenastavke) {
        vratiArtikle();
        for (Object artikalRaw:listaArtikala) {
            ArtikalEntity Artikal = (ArtikalEntity) artikalRaw;
            if (sifraartikla == Artikal.getSifraartikla()) {
                p.izmeniStavku(rbr, Artikal, kolicina, napomenastavke);
            }
        }
    }

    public void obrisiStavku(int rbr){

        p.obrisiStavku(rbr);
    }

    //TODO: Dodeliti redni broj - for broj clanova if in array..
    public int dodajRbr(){

        if (p.getKolekcijaStavki() != null) {

            int tempRbr = p.getKolekcijaStavki().size() + 1;


            return tempRbr;
        } else {
            return 1;
        }
    }

} //end servlet
