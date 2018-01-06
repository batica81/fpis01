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
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery.populate.js"></script>
    <script type="text/javascript" src="js/moment-with-locales.min.js"></script>
    <script type="text/javascript" src="js/tablesorter.min.js"></script>
    <script type="text/javascript" src="js/app.js"></script>

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/jquery-ui.min.css">
    <link rel="stylesheet" href="css/jquery-ui.structure.min.css">
    <link rel="stylesheet" href="css/jquery-ui.theme.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="shortcut icon" href="css/images/favicon.ico">

    <title>FPIS Aplikacija</title>
  </head>
  <body>

  <!-- Static navbar -->
  <nav class="navbar navbar-default navbar-static-top">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="index.jsp">FPIS Aplikacija</a>
      </div>
      <div id="navbar" class="navbar-collapse collapse">
        <ul class="nav navbar-nav">
          <li><a id="dugmeunos" href="ArtikalForma.jsp">Unos artikla</a></li>
          <li><a id="dugmeizmena" href="ArtikalForma.jsp">Izmena artikla</a></li>
          <li><a href="PonudaForma.jsp">Unos ponude</a></li>
          <li><a href="PonudaForma.jsp">Izmena Ponude</a></li>
        </ul>
      </div><!--/.nav-collapse -->
    </div>
  </nav>

  <div class="welcome container">

    <h3>Dobrodošli !</h3>

    <p>Preduzeće VWG Inženjering d.o.o. iz Beograda se bavi prodajom, instalacijom i održavanjem sistema tehničke zaštite, kao i pružanjem konsultantskih usluga iz oblasti fizičko-tehničke bezbednosti.</p>
    <br>

    <h4>Ova aplikacija predstavlja implementaciju podmodela - <strong>		Prodaja proizvoda</strong> - poslovnog procesa firme VWG.</h4>

    <br>
    <p>Proces prodaje proizvoda počinje prijemom upita kupca koji pristiže elektronskom poštom ili telefonom. Na osnovu upita, unose se osnovni podaci kupca u bazu i kreira se ponuda koja se dostavljaju kupcu. Ponuda sadrži spsiak traženih artikala sa aktuelnim cenama.
    </p>

  </div>


  <script type="text/javascript">
      $(document).ready(function () {
        $('#dugmeizmena').click(function () {
           $('#combo').removeClass('hidden');
           $('#updateBbutton').removeClass('hidden');
           $('#deleteBbutton').removeClass('hidden');
           $('#insertBbutton').addClass('hidden');
        });

        $('#dugmeunos').click(function () {
            $('#combo').addClass('hidden');
            $('#updateBbutton').addClass('hidden');
            $('#deleteBbutton').addClass('hidden');
            $('#insertBbutton').removeClass('hidden');
        });

        $('.inputfield').val('');
      });

  </script>


  <div id="footer" class="navbar-fixed-bottom">
    <div class="container">
      <p class="">Copyright &copy; 2018 Vojislav Ristivojević, 2016/3079</p>
    </div>
  </div>

  </body>
</html>
