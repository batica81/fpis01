package com.fpis.test.kontroler;

import com.fpis.test.model.ArtikalEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        SessionFactory factory;
//        factory = new Configuration().configure().addAnnotatedClass(ArtikalEntity.class).buildSessionFactory();
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        List lista = session.getSession().createCriteria(ArtikalEntity.class).list();

        PrintWriter out = response.getWriter();
        JSONArray arr = new JSONArray();

        for (Object artikalRaw:lista) {

            JSONObject obj = new JSONObject();
            ArtikalEntity artikal = (ArtikalEntity) artikalRaw;

            obj.put("jedinicamere", artikal.getJedinicamere());
            obj.put("opisartikla", artikal.getOpisartikla());
            obj.put("nazivartikla", artikal.getNazivartikla());
            obj.put("sifraartikla", artikal.getSifraartikla());

            arr.add(obj);
        }

        out.println(arr);
        session.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Yo MAMA!<br>");


        SessionFactory factory;
        factory = new Configuration().configure().addAnnotatedClass(ArtikalEntity.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();

        Long artId = Long.valueOf(request.getParameter("articleId"));

        ArtikalEntity artikal = (ArtikalEntity) session.get(ArtikalEntity.class, artId);


        JSONObject obj = new JSONObject();

        obj.put("sifraartikla", artikal.getSifraartikla());
        obj.put("nazivartikla", artikal.getNazivartikla());
        obj.put("opisartikla", artikal.getOpisartikla());
        obj.put("jedinicamere", artikal.getJedinicamere());

        out.println(artikal.getNazivartikla());
        out.println("<br><br>");
        out.println(obj);

        transaction.commit();
        session.close();

    } //end doGet

} //end servlet
