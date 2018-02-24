<%@ page import="com.fpis.test.kontroler.ArtikalKontroler" %><%--
  Created by IntelliJ IDEA.
  User: voja
  Date: 4.1.18.
  Time: 20.33
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
    <script type="text/javascript" src="js/jquery.form.min.js"></script>
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

<%
    String listaArtikala;
    String artikalJSON;

//    popuniPoljaForme(artikalJSON)

//    start()
//    odaberiArtikal(SifraArtikla)
//    PronadjiArtikal(SifraArtikla)
//    PrikaziArtikle(listaArtikala)
//    izmeni()
//    Sacuvaj()



    ArtikalKontroler k = new ArtikalKontroler();

    listaArtikala = k.vratiArtikle();

//    out.println(listaArtikala);

    artikalJSON = k.pronadjiArtikal(1);

//    out.println("<h2>TRAZENI ARTIKAL JE:</h2>");
//    out.println(artikalJSON);
%>


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
                <li><a id="dugmeizmena" href="#">Izmena artikla</a></li>
                <li><a href="PonudaForma.jsp">Unos ponude</a></li>
                <li><a href="PonudaForma.jsp">Izmena Ponude</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<div class="container artikalforma">
    <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Unos artikla</h3>
                    <h3 class="panel-title hidden">Izmena artikla</h3>
                </div>
                <select name="combo" id="combo" class="dropdown form-control hidden">
                    <option value="0" selected>Odaberite artikal za izmenu</option>
                </select>
                <div class="panel-body">
                    <form id="artikalForma" class="" action="artikalkontroler" method="post" role="form">
                        <div class="form-group form-inline">
                            <label for="sifraartikla">Šifra artikla</label>
                            <input readonly class="inputfield form-control input-lg" type="text" placeholder="Šifra artikla"
                                   id="sifraartikla" name="sifraartikla">
                        </div>
                        <div class="form-group form-inline">
                            <label for="nazivartikla">Naziv artikla</label>
                            <input class="inputfield form-control input-lg" type="text" placeholder="Naziv artikla" id="nazivartikla" name="nazivartikla" required>
                        </div>
                        <div class="form-group form-inline">
                            <label for="opisartikla">Opis artikla</label>
                            <input class="inputfield form-control input-lg" type="text" placeholder="Opis artikla" id="opisartikla" name="opisartikla">
                        </div>
                        <div class="form-group form-inline">
                            <label for="jedinicamere">Jedinica mere</label>
                            <input class="inputfield form-control input-lg" type="text" placeholder="Jedinica mere" id="jedinicamere" name="jedinicamere">
                        </div>
                        <div class="form-group form-inline">
                            <label for="cena">Cena</label>
                            <input class="inputfield form-control input-lg" type="number" placeholder="Cena"
                                   id="cena" name="cena">
                        </div>
                        <input hidden id="stautsinput" type="text" name="status">

                        <button id="insertBbutton" class="btn-lg btn-block btn-info" type="submit">Unesi artikal</button>
                        <button id="updateBbutton" type="submit" class="btn-lg btn-block btn-success hidden">Izmeni artikal</button>
                        <button id="deleteBbutton" type="submit" class="btn-lg btn-block btn-danger hidden">Obriši artikal</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function () {

        $("#insertBbutton").click(function () {
            $("#stautsinput").val("insert");
            $("#sifraartikla").val(0);
        });

        $("#updateBbutton").click(function () {
            $("#stautsinput").val("update");
        });

        $("#deleteBbutton").click(function () {
            $("#stautsinput").val("delete");
        });

        // function vratiArtikle() {
        //     $.ajax({
        //         url: "http://localhost:8080/fpis01_war_exploded/artikalkontroler",
        //         method: "GET",
        //         success:
        //             function (data) {
        //                 populateComboBox(data);
        //                 listaArtikala = data;
        //             },
        //         error:
        //             function (e) {
        //                 console.log(e.responseText);
        //             }
        //     });
        // }

        //TODO: pretvoriti u JSP

        function populateComboBox(data) {
            $(data).map(function () {
                $('<option>').val(this.sifraartikla).text(this.nazivartikla).appendTo('#combo');
            });
        }

        function popuniFormu(selected) {
            // listaArtikala.forEach( function (artikal) {
            //     if (artikal.sifraartikla == selected){
                    $('#artikalForma').populate(selected);
                // }
            // });
        }

        // vratiArtikle();

        populateComboBox(<% out.println(listaArtikala); %>);

        $('#combo').change(function () {
            selected = $('#combo').find('option:selected').val();
            popuniFormu(selected);
        });

        $('#dugmeizmena').click(function () {
            $('#combo').toggleClass('hidden');
            $('#updateBbutton').toggleClass('hidden');
            $('#deleteBbutton').toggleClass('hidden');
            $('.panel-title').toggleClass('hidden');
            $('#insertBbutton').toggleClass('hidden');
        });

        // $('#dugmeunos').click(function () {
        //     $('#combo').addClass('hidden');
        //     $('#updateBbutton').addClass('hidden');
        //     $('#deleteBbutton').addClass('hidden');
        //     $('#insertBbutton').removeClass('hidden');
        // });

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
