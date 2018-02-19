package com.fpis.test.kontroler;

import com.fpis.test.dbbroker.DBbroker;
import com.fpis.test.model.ArtikalEntity;
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
import java.util.List;

@WebServlet(name = "ArtikalKontroler", urlPatterns = {"/artikalkontroler"})
public class ArtikalKontroler extends HttpServlet {
    private DBbroker dbb = new DBbroker();
    private List<ArtikalEntity> listaArtikala;
    private boolean ret;
    ArtikalEntity artikal = new ArtikalEntity();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        listaArtikala = vratiArtikle();

        // Vrati listu artikala u JSON formatu
        PrintWriter out = response.getWriter();
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
        out.println(arr);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String status = String.valueOf(request.getParameter("status"));
        Integer Sifraartikla = Integer.valueOf(request.getParameter("sifraartikla"));
        Integer Cena = Integer.valueOf(request.getParameter("cena"));
        String Nazivartikla = String.valueOf(request.getParameter("nazivartikla"));
        String Opisartikla = String.valueOf(request.getParameter("opisartikla"));
        String Jedinicamere = String.valueOf(request.getParameter("jedinicamere"));

        if (status.equals("insert")) {
            sacuvajArtikal(Sifraartikla, Nazivartikla, Opisartikla, Jedinicamere, Cena);
        }
        else if (status.equals("update")) {
            izmeniArtikal(Sifraartikla, Nazivartikla, Opisartikla, Jedinicamere, Cena);
        }
        else if (status.equals("delete")) {
            obrisiArtikal(Sifraartikla);
        }

        RequestDispatcher view = request.getRequestDispatcher("html/back.html");
        view.forward(request, response);
    } //end doPost

    public List<ArtikalEntity> vratiArtikle(){
        dbb.pokreniDBTransakciju();
        List<ArtikalEntity> listaArtikala  = dbb.vratiArtikle();
        dbb.potvrdiDBTransakciju();
        return listaArtikala;
    }

    public void sacuvajArtikal(int Sifraartikla, String Nazivartikla, String Opisartikla, String Jedinicamere, int Cena){
        artikal.setSifraartikla(Sifraartikla);
        artikal.setNazivartikla(Nazivartikla);
        artikal.setOpisartikla(Opisartikla);
        artikal.setJedinicamere(Jedinicamere);
        artikal.setCena(Cena);
        artikal.setStatus("insert");

        dbb.pokreniDBTransakciju();
        ret = dbb.zapamtiArtikal(artikal);

        if(ret)
            dbb.potvrdiDBTransakciju();
        else
            dbb.ponistiDBTransakciju();
    }

    public void izmeniArtikal(int Sifraartikla, String Nazivartikla, String Opisartikla, String Jedinicamere, int Cena){
        artikal.setSifraartikla(Sifraartikla);
        artikal.setNazivartikla(Nazivartikla);
        artikal.setOpisartikla(Opisartikla);
        artikal.setJedinicamere(Jedinicamere);
        artikal.setCena(Cena);
        artikal.setStatus("update");

        dbb.pokreniDBTransakciju();
        ret = dbb.zapamtiArtikal(artikal);

        if(ret)
            dbb.potvrdiDBTransakciju();
        else
            dbb.ponistiDBTransakciju();
    }

    public void obrisiArtikal(int Sifraartikla){
        artikal.setSifraartikla(Sifraartikla);
        artikal.setStatus("delete");

        dbb.pokreniDBTransakciju();
        ret = dbb.zapamtiArtikal(artikal);

        if(ret)
            dbb.potvrdiDBTransakciju();
        else
            dbb.ponistiDBTransakciju();
    }

//    TODO: obavezno upotrebiti
    public ArtikalEntity pronadjiArtikal(int SifraArtikla) {
        dbb.pokreniDBTransakciju();
        ArtikalEntity artikal = dbb.pronadjiArtikal(SifraArtikla);
        dbb.potvrdiDBTransakciju();
        return artikal;
    }
} //end servlet
