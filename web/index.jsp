<%--
  Created by IntelliJ IDEA.
  User: Voja
  Date: 13-Oct-17
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>FPIS Aplikacija</title>
  </head>
  <body>
  <h2>FPIS Aplikacija</h2>


  <form method="post" action="artikalkontroler">
    <input type="hidden" title="articleId" value="insert" name="status">
    <input type="text" title="articleId" placeholder="Nazivartikla"  name="Nazivartikla">
    <input type="text" title="articleId" placeholder="Opisartikla"  name="Opisartikla">
    <input type="text" title="articleId" placeholder="Jedinicamere"  name="Jedinicamere">
    <input type="hidden" title="articleId" value="0" name="Sifraartikla">
    <button type="submit">Dodaj artikal</button>
  </form>

  <form method="get" action="artikalkontroler">
    <button type="submit">Izlistaj sve artikle</button>
  </form>
  </body>
</html>
