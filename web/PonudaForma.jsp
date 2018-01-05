<%--
  Created by IntelliJ IDEA.
  User: voja
  Date: 4.1.18.
  Time: 20.34
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
    <title>Title</title>
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
            <a class="navbar-brand" href="index.jsp">VWG Inženjering</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a id="dugmeunos" href="ArtikalForma.jsp">Unos artikla</a></li>
                <li><a id="dugmeizmena" href="ArtikalForma.jsp">Izmena artikla</a></li>
                <li><a href="PonudaForma.jsp">Unos ponude</a></li>
                <li><a href="#">Izmena Ponude</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<div class="container ponudaforma">
    <div class="row centered-form">
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Unos ponude</h3>
                    <h3 class="panel-title hidden">Izmena ponude</h3>
                </div>
                <select name="combo" id="combo" class="dropdown form-control 5hidden">
                    <option value="0" selected>Odaberite ponudu za izmenu</option>
                </select>
                <div class="panel-body">
                    <form id="ponudaForma" class="" action="ponudakontroler" method="post" role="form">

                        <div class="col-left">
                            <div class="form-group form-inline">
                                <label for="BrPonude">Broj ponude</label>
                                <input readonly class="inputfield form-control input-lg" type="text" placeholder="Broj ponude" id="BrPonude" name="BrPonude" required>
                            </div>
                            <div class="form-group form-inline">
                                <label for="datum">Datum</label>
                                <input class="inputfield form-control input-lg" type="text" placeholder="Datum" id="datum" name="datum">
                            </div>
                            <div class="form-group form-inline">
                                <label for="sifraKupca">Sifra kupca</label>
                                <input class="inputfield form-control input-lg" type="text" placeholder="Sifra kupca" id="sifraKupca" name="sifraKupca">
                            </div>
                            <div class="form-group form-inline">
                                <label for="sifraRadnika">Sifra radnika</label>
                                <input class="inputfield form-control input-lg" type="text" placeholder="Sifra radnika" id="sifraRadnika" name="sifraRadnika">
                            </div>
                            <div class="form-group form-inline">
                                <label for="isporuka">Isporuka</label>
                                <input class="inputfield form-control input-lg" type="text" placeholder="Isporuka" id="isporuka" name="isporuka">
                            </div>
                            <div class="form-group form-inline">
                                <label for="banka">Banka</label>
                                <input class="inputfield form-control input-lg" type="text" placeholder="Banka" id="banka" name="banka">
                            </div>
                            <div class="form-group form-inline">
                                <label for="tekuciRacun">Tekuci racun</label>
                                <input class="inputfield form-control input-lg" type="text" placeholder="Tekuci racun" id="tekuciRacun" name="tekuciRacun">
                            </div>
                        </div>

                        <div class="col-right">
                            <div class="form-group form-inline">
                                <label for="uslovi">Uslovi</label>
                                <input class="inputfield form-control input-lg" type="text" placeholder="Uslovi" id="uslovi" name="uslovi">
                            </div>
                            <div class="form-group form-inline">
                                <label for="napomena">Napomena</label>
                                <input class="inputfield form-control input-lg" type="text" placeholder="Napomena" id="napomena" name="napomena">
                            </div>
                            <div class="form-group form-inline">
                                <label for="validnost">Validnost</label>
                                <input class="inputfield form-control input-lg" type="text" placeholder="Validnost" id="validnost" name="validnost">
                            </div>
                            <div class="form-group form-inline">
                                <label for="pozivNaBroj">Poziv na broj</label>
                                <input class="inputfield form-control input-lg" type="text" placeholder="Poziv na broj" id="pozivNaBroj" name="pozivNaBroj">
                            </div>
                            <div class="form-group form-inline">
                                <label for="mesto">Mesto</label>
                                <input class="inputfield form-control input-lg" type="text" placeholder="Mesto" id="mesto" name="mesto">
                            </div>
                            <div class="form-group form-inline">
                                <label for="datumPrometa">Datum prometa</label>
                                <input class="inputfield form-control input-lg" type="text" placeholder="Datum prometa" id="datumPrometa" name="datumPrometa">
                            </div>
                            <div class="form-group form-inline">
                                <label for="tipPlacanja">Tip placanja</label>
                                <input class="inputfield form-control input-lg" type="text" placeholder="Tip placanja" id="tipPlacanja" name="tipPlacanja">
                            </div>
                        </div>


                        <div class="ponuda_omot">
                            <h3>Detalji ponude</h3>

                            <div class="row centered-form">
                                <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h3 class="panel-title">Dodajte novu stavku ponude</h3>
                                        </div>
                                        <div class="panel-body">
                                            <form action="dodaj_stavke_ponude.php" method="post" role="form">
                                                <input type="hidden" name="BRPONUDE" value="57">

                                                <div class="form-group">
                                                    <label class="control-label" for="select_SIFRAARTIKLA">Izaberi artikal</label>
                                                    <select id="select_SIFRAARTIKLA" name="SIFRAARTIKLA" class="form-control">

                                                    </select>
                                                </div>

                                                <div class="form-group">
                                                    <label class="control-label" for="kolicina">Unesi količinu</label>
                                                    <input type="number" min="1" step="1" name="KOLICINA" class="form-control input-sm" placeholder="Kolicina" required>

                                                </div>

                                                <button id="singlebutton" name="singlebutton" class="btn btn-info">Dodaj stavku ponude</button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div>
                                <h4>Stavke ponude</h4>

                                <table id="detalji_ponude" border='1' class='table table-striped table-condensed'></table>
                            </div>
                        </div>


                        <input hidden id="stautsinput" type="text" name="status">
                        <button id="insertBbutton" class="btn-lg btn-block btn-info" type="submit">Unesi ponudu</button>
                        <button id="updateBbutton" type="submit" class="btn-lg btn-block btn-success hidden">Izmeni ponudu</button>
                        <button id="deleteBbutton" type="submit" class="btn-lg btn-block btn-danger hidden">Obriši ponudu</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>



<script type="text/javascript">
    $(document).ready(function () {

        function vratiPonude() {
            $.ajax({
                url: "http://localhost:8080/fpis01_war_exploded/ponudakontroler",
                method: "GET",
                success:
                    function (data) {
                        populateComboBox(data);
                        listaPonuda = data;
                    },
                error:
                    function (e) {
                        console.log(e.responseText);
                    }
            });
        }

        function vratiArtikle() {
            $.ajax({
                url: "http://localhost:8080/fpis01_war_exploded/artikalkontroler",
                method: "GET",
                success:
                    function (data) {
                        populateArtikalComboBox(data);
                        listaArtikala = data;
                    },
                error:
                    function (e) {
                        console.log(e.responseText);
                    }
            });
        }

        function populateComboBox(data) {
            $(data).map(function () {
                $('<option>').val(this.BrPonude).text(this.banka).appendTo('#combo');
            });
        }

        function populateArtikalComboBox(data) {
            $(data).map(function () {
                $('<option>').val(this.sifraartikla).text(this.nazivartikla).appendTo('#select_SIFRAARTIKLA');
            });
        }

        function popuniFormu(selected) {
            listaPonuda.forEach( function (ponuda) {
                if (ponuda.BrPonude == selected){
                    $('#ponudaForma').populate(ponuda);
                }
            });
        }

        vratiPonude();

        vratiArtikle();

        Tablify_stavka(listaArtikala, '#detalji_ponude', 'RBR');


        $('#combo').change(function () {
            selected = $('#combo').find('option:selected').val();
            popuniFormu(selected);
        });

        $("#insertBbutton").click(function () {
            $("#stautsinput").val("insert");
            $("#BrPonude").val(0);
        });

        $("#updateBbutton").click(function () {
            $("#stautsinput").val("update");
        });

        $("#deleteBbutton").click(function () {
            $("#stautsinput").val("delete");
        });

    });

</script>
<div id="footer" class="navbar-fixed-bottom">
    <div class="container">
        <p class="">Copyright &copy; 2018 Vojislav Ristivojević, 2016/3079</p>
    </div>
</div>

</body>
</html>
