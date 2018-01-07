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
    ArtikalEntity artikal = new ArtikalEntity();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        vratiArtikle();

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
            arr.add(obj);
        }
        out.println(arr);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String status = String.valueOf(request.getParameter("status"));
        Integer Sifraartikla = Integer.valueOf(request.getParameter("sifraartikla"));
        String Nazivartikla = String.valueOf(request.getParameter("nazivartikla"));
        String Opisartikla = String.valueOf(request.getParameter("opisartikla"));
        String Jedinicamere = String.valueOf(request.getParameter("jedinicamere"));

        if (status.equals("insert")) {
            dodajArtikal(Sifraartikla, Nazivartikla, Opisartikla, Jedinicamere);
        }
        else if (status.equals("update")) {
            izmeniArtikal(Sifraartikla, Nazivartikla, Opisartikla, Jedinicamere);
        }
        else if (status.equals("delete")) {
            obrisiArtikal(Sifraartikla);
        }

        RequestDispatcher view = request.getRequestDispatcher("html/back.html");
        view.forward(request, response);
    } //end doPost

    public void vratiArtikle(){
        dbb.pokreniDBTransakciju();
        listaArtikala  = dbb.vratiArtikle();
        dbb.potvrdiDBTransakciju();
    }

    public void dodajArtikal(int Sifraartikla, String Nazivartikla, String Opisartikla, String Jedinicamere){
        artikal.setSifraartikla(Sifraartikla);
        artikal.setNazivartikla(Nazivartikla);
        artikal.setOpisartikla(Opisartikla);
        artikal.setJedinicamere(Jedinicamere);
        artikal.setStatus("insert");

        dbb.pokreniDBTransakciju();
        boolean ret = dbb.zapamtiArtikal(artikal);

        if(ret)
            dbb.potvrdiDBTransakciju();
        else
            dbb.ponistiDBTransakciju();
    }

    public void izmeniArtikal(int Sifraartikla, String Nazivartikla, String Opisartikla, String Jedinicamere){
        artikal.setSifraartikla(Sifraartikla);
        artikal.setNazivartikla(Nazivartikla);
        artikal.setOpisartikla(Opisartikla);
        artikal.setJedinicamere(Jedinicamere);
        artikal.setStatus("update");

        dbb.pokreniDBTransakciju();
        boolean ret = dbb.zapamtiArtikal(artikal);

        if(ret)
            dbb.potvrdiDBTransakciju();
        else
            dbb.ponistiDBTransakciju();
    }

    public void obrisiArtikal(int Sifraartikla){
        artikal.setSifraartikla(Sifraartikla);
        artikal.setStatus("delete");

        dbb.pokreniDBTransakciju();
        boolean ret = dbb.zapamtiArtikal(artikal);

        if(ret)
            dbb.potvrdiDBTransakciju();
        else
            dbb.ponistiDBTransakciju();
    }

} //end servlet
