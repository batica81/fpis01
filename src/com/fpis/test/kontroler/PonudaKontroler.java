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
    private DBbroker dbb = new DBbroker();
    private PonudaEntity p = new PonudaEntity();
    private boolean ret;
    private List<PonudaEntity> listaPonuda;
    private List<ArtikalEntity> listaArtikala;
    private List<KupacEntity> listaKupaca;
    private List<RadnikEntity> listaRadnika;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        listaPonuda = vratiPonude();
        listaArtikala = vratiArtikle();
        listaKupaca = vratiKupce();
        listaRadnika = vratiRadnike();

        // Konvertuj listu p u JSON format
        PrintWriter out = response.getWriter();
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


        out.println(listaPonudaJSON);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int brPonude = Integer.valueOf(request.getParameter("BrPonude"));

        if ((Integer) p.getBrPonude() == 0)  {

//        if ( String.valueOf(request.getParameter("status")).equalsIgnoreCase("update")){

            for (Object ponudaRaw : listaPonuda) {
                PonudaEntity aktuelnaPonuda = (PonudaEntity) ponudaRaw;
                if (brPonude == aktuelnaPonuda.getBrPonude()) {
                    p = aktuelnaPonuda;
                }
            }
        }

            if (request.getParameterMap().containsKey("radsastavkom")) {

                String status = String.valueOf(request.getParameter("status"));
                int kolicina = Integer.valueOf(request.getParameter("KOLICINA"));
                int rbr = Integer.valueOf(request.getParameter("rbr"));
//                int BrPonude = Integer.valueOf(request.getParameter("BrPonude"));
                int sifraartikla = Integer.valueOf(request.getParameter("SIFRAARTIKLA"));
                String napomenastavke = String.valueOf(request.getParameter("napomenastavke"));

                if (status.equals("insert")) {
                    dodajStavku(rbr, sifraartikla, kolicina, napomenastavke);
                } else if (status.equals("update")) {
                    izmeniStavku(rbr, sifraartikla, kolicina, napomenastavke);
                } else if (status.equals("delete")) {
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

            if (status.equals("insert")) {
                dodajPonudu(p.getBrPonude(), datum, sifraKupca, sifraRadnika, isporuka, banka, tekuciRacun, uslovi, napomena, validnost,
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

    public List<PonudaEntity> vratiPonude(){
        dbb.pokreniDBTransakciju();
        return dbb.vratiPonude();
    }

    public List<ArtikalEntity> vratiArtikle(){
        dbb.pokreniDBTransakciju();
        return dbb.vratiArtikle();
    }

    public List<RadnikEntity> vratiRadnike(){
        dbb.pokreniDBTransakciju();
        return dbb.vratiRadnike();
    }

    public List<KupacEntity> vratiKupce(){
        dbb.pokreniDBTransakciju();
        return dbb.vratiKupce();
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
            p = new PonudaEntity();
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

    public void dodajStavku(int rbr, int sifraartikla, int kolicina, String napomenastavke){

        // TODO: Nalazenje sledeceg rednog broja
//        int brojStavki = p.getStavkaPonudesByBrPonude().size();
//
//        for (StavkaPonudeEntity stavka : p.getStavkaPonudesByBrPonude()){
//            ArrayList redniBrojevi = new ArrayList();
//            redniBrojevi.add(stavka.getRbr());
//        }

        ArtikalEntity odabraniArtikal = new ArtikalEntity();
        // Biranje artikla po sifri
        for (Object artikalRaw:listaArtikala) {
            ArtikalEntity Artikal = (ArtikalEntity) artikalRaw;
            if (sifraartikla == Artikal.getSifraartikla()) {
                odabraniArtikal = Artikal;
            }
        }

        p.dodajStavku(rbr, odabraniArtikal, kolicina, napomenastavke);

    }

    public void izmeniStavku(int rbr, int sifraartikla, int kolicina, String napomenastavke) {
        for (Object artikalRaw:listaArtikala) {
            ArtikalEntity Artikal = (ArtikalEntity) artikalRaw;
            if (sifraartikla == Artikal.getSifraartikla()) {
                p.dodajStavku(rbr, Artikal, kolicina, napomenastavke);
            }
        }
    }

    public void obrisiStavku(int rbr){

        Collection<StavkaPonudeEntity> stavkePonude = p.getKolekcijaStavki();
        for (Object spRaw:stavkePonude) {

            StavkaPonudeEntity sp = (StavkaPonudeEntity) spRaw;

            if(sp.getRbr()==rbr) {
                sp.postaviStatus("delete");
            }
        }
    }

    //TODO: Dodeliti redni broj nekako
    public int dodajRbr(){
        return 0;
    }

} //end servlet
