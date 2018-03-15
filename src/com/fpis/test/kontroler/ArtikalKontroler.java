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
    private List<ArtikalEntity> listaArtikala;
    private boolean ret;
    private DBbroker dbb = new DBbroker();
    private ArtikalEntity a = new ArtikalEntity();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println(pronadjiArtikal(Integer.valueOf(request.getParameter("sifraArtikla"))));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String status = String.valueOf(request.getParameter("status"));
        Integer Cena = Integer.valueOf(request.getParameter("cena"));
        String Nazivartikla = String.valueOf(request.getParameter("nazivartikla"));
        String Opisartikla = String.valueOf(request.getParameter("opisartikla"));
        String Jedinicamere = String.valueOf(request.getParameter("jedinicamere"));

        if (status.equals("insert")) {
            sacuvajArtikal(0, Nazivartikla, Opisartikla, Jedinicamere, Cena);
        }
        else if (status.equals("update")) {
            izmeniArtikal(a.getSifraartikla(), Nazivartikla, Opisartikla, Jedinicamere, Cena);
        }
        else if (status.equals("delete")) {
            obrisiArtikal(a.getSifraartikla());
        }

        RequestDispatcher view = request.getRequestDispatcher("html/back.html");
        view.forward(request, response);
    } //end doPost

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

    public String pronadjiArtikal(int SifraArtikla) {
        dbb.pokreniDBTransakciju();
        a = dbb.pronadjiArtikal(SifraArtikla);
        dbb.potvrdiDBTransakciju();
        JSONObject obj = new JSONObject();

        obj.put("jedinicamere", a.getJedinicamere());
        obj.put("opisartikla", a.getOpisartikla());
        obj.put("nazivartikla", a.getNazivartikla());
        obj.put("sifraartikla", a.getSifraartikla());
        obj.put("cena", a.getCena());

        return String.valueOf(obj);
    }

    public void sacuvajArtikal(int Sifraartikla, String Nazivartikla, String Opisartikla, String Jedinicamere, int Cena){
        a.setSifraartikla(Sifraartikla);
        a.setNazivartikla(Nazivartikla);
        a.setOpisartikla(Opisartikla);
        a.setJedinicamere(Jedinicamere);
        a.setCena(Cena);
        a.setStatus("insert");

        dbb.pokreniDBTransakciju();
        ret = dbb.zapamtiArtikal(a);

        if(ret)
            dbb.potvrdiDBTransakciju();
        else
            dbb.ponistiDBTransakciju();
    }

    public void izmeniArtikal(int Sifraartikla, String Nazivartikla, String Opisartikla, String Jedinicamere, int Cena){
        a.setSifraartikla(Sifraartikla);
        a.setNazivartikla(Nazivartikla);
        a.setOpisartikla(Opisartikla);
        a.setJedinicamere(Jedinicamere);
        a.setCena(Cena);
        a.setStatus("update");

        dbb.pokreniDBTransakciju();
        ret = dbb.zapamtiArtikal(a);

        if(ret)
            dbb.potvrdiDBTransakciju();
        else
            dbb.ponistiDBTransakciju();
    }

    public void obrisiArtikal(int Sifraartikla){
        a.setSifraartikla(Sifraartikla);
        a.setStatus("delete");

        dbb.pokreniDBTransakciju();
        ret = dbb.zapamtiArtikal(a);

        if(ret)
            dbb.potvrdiDBTransakciju();
        else
            dbb.ponistiDBTransakciju();
    }

} //end servlet
