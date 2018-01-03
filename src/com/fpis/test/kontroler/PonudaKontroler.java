package com.fpis.test.kontroler;

import com.fpis.test.dbbroker.DBbroker;
import com.fpis.test.model.PonudaEntity;
import com.fpis.test.model.StavkaPonudeEntity;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
    private List<PonudaEntity> listaPonuda;
    PonudaEntity ponuda;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        vratiPonude();

        // Vrati listu ponuda u JSON formatu
        PrintWriter out = response.getWriter();
        JSONArray listaPonudaJSON = new JSONArray();

        for (Object ponudaRaw:listaPonuda) {

            PonudaEntity ponuda = (PonudaEntity) ponudaRaw;
            JSONObject ponudaJson = new JSONObject();
            JSONArray listaStavkiJson = new JSONArray();
            Collection<StavkaPonudeEntity> stavkePonude = ponuda.getStavkaPonudesByBrPonude();

            for (Object stavkaRaw:stavkePonude) {
                JSONObject stavkaJson = new JSONObject();
                StavkaPonudeEntity stavka = (StavkaPonudeEntity) stavkaRaw;
                stavkaJson.put("Rbr", stavka.getRbr());
                stavkaJson.put("Kolicina", stavka.getKolicina());
                stavkaJson.put("Artikal", stavka.getArtikalBySifraArtikla().getNazivartikla());
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

        //TODO: Proveriti da li su sva polja popisana svuda

        out.println(listaPonudaJSON);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String status = String.valueOf(request.getParameter("status"));
        int brPonude = Integer.valueOf(request.getParameter("brPonude"));
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
            zapamtiPonudu(brPonude, datum, sifraKupca, sifraRadnika, isporuka, banka, tekuciRacun, uslovi, napomena, validnost,
                    pozivNaBroj, mesto,datumPrometa, tipPlacanja);
        }
        else if (status.equals("update")) {
            izmeniPonudu(brPonude, datum, sifraKupca, sifraRadnika, isporuka, banka, tekuciRacun, uslovi, napomena, validnost,
                    pozivNaBroj, mesto,datumPrometa, tipPlacanja);
        }
        else if (status.equals("delete")) {
            obrisiPonudu(brPonude);
        }

        PrintWriter out = response.getWriter();
        out.println("OK!");
    } //end doPost

    public void vratiPonude(){
        dbb.pokreniDBTransakciju();
        listaPonuda  = dbb.vratiPonude();
        dbb.potvrdiDBTransakciju();
    }

    public void zapamtiPonudu(int brPonude, Timestamp datum, int sifraKupca, int sifraRadnika, String isporuka, String banka, String tekuciRacun, String uslovi, String napomena, String validnost, String pozivNaBroj, String mesto, Timestamp datumPrometa, String tipPlacanja){
        ponuda = new PonudaEntity();
        ponuda.setBrPonude(brPonude);
        ponuda.setDatum(datum);
        ponuda.setSifraKupca(sifraKupca);
        ponuda.setSifraRadnika(sifraRadnika);
        ponuda.setIsporuka(isporuka);
        ponuda.setBanka(banka);
        ponuda.setTekuciRacun(tekuciRacun);
        ponuda.setUslovi(uslovi);
        ponuda.setNapomena(napomena);
        ponuda.setValidnost(validnost);
        ponuda.setPozivNaBroj(pozivNaBroj);
        ponuda.setMesto(mesto);
        ponuda.setDatumPrometa(datumPrometa);
        ponuda.setTipPlacanja(tipPlacanja);
        ponuda.setStatus("insert");

        dbb.pokreniDBTransakciju();
        boolean ret = dbb.zapamtiPonudu(ponuda);
        if(ret)
            dbb.potvrdiDBTransakciju();
        else
            dbb.ponistiDBTransakciju();
    }

    public void izmeniPonudu(int brPonude, Timestamp datum, int sifraKupca, int sifraRadnika, String isporuka, String banka, String tekuciRacun, String uslovi, String napomena, String validnost, String pozivNaBroj, String mesto, Timestamp datumPrometa, String tipPlacanja){
        ponuda = new PonudaEntity();
        ponuda.setBrPonude(brPonude);
        ponuda.setDatum(datum);
        ponuda.setSifraKupca(sifraKupca);
        ponuda.setSifraRadnika(sifraRadnika);
        ponuda.setIsporuka(isporuka);
        ponuda.setBanka(banka);
        ponuda.setTekuciRacun(tekuciRacun);
        ponuda.setUslovi(uslovi);
        ponuda.setNapomena(napomena);
        ponuda.setValidnost(validnost);
        ponuda.setPozivNaBroj(pozivNaBroj);
        ponuda.setMesto(mesto);
        ponuda.setDatumPrometa(datumPrometa);
        ponuda.setTipPlacanja(tipPlacanja);
        ponuda.setStatus("update");

        dbb.pokreniDBTransakciju();
        boolean ret = dbb.zapamtiPonudu(ponuda);
        if(ret)
            dbb.potvrdiDBTransakciju();
        else
            dbb.ponistiDBTransakciju();
    }

    public void obrisiPonudu(int brPonude){
        ponuda = new PonudaEntity();
        ponuda.setBrPonude(brPonude);
        ponuda.setStatus("delete");

        dbb.pokreniDBTransakciju();
        boolean ret = dbb.zapamtiPonudu(ponuda);
        if(ret)
            dbb.potvrdiDBTransakciju();
        else
            dbb.ponistiDBTransakciju();
    }
} //end servlet
