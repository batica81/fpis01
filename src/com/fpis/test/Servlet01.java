package com.fpis.test;

import com.fpis.test.model.ArtikalEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import static java.lang.Class.forName;

@WebServlet(name = "Servlet01", urlPatterns = {"/yomama"})
public class Servlet01 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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


        out.println(artikal.getNazivartikla());

        transaction.commit();

        session.close();


    } //end doGet

} //end servlet
