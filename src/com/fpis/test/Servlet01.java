package com.fpis.test;

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Yo MAMA!");

//        god object



        String url = "jdbc:oracle:thin://@192.168.1.20:1521/orcl";

         Connection connection = null;
        ResultSet results = null;

        try {
            forName("oracle.jdbc.driver.OracleDriver").newInstance();
            try {
                connection = DriverManager.getConnection(url,"db02","fon123");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        String query = "SELECT * FROM ARTIKAL";
        PreparedStatement ps = null;
        try {
            assert connection != null;
            ps = connection.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            results = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (results.next()) {
                try {
                    out.println(results.getString(2));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
