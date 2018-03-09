<%--  Created by IntelliJ IDEA.
  User: voja
  Date: 4.1.18.
  Time: 20.34
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="com.fpis.test.kontroler.PonudaKontroler" %>
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
                <li><a id="dugmeunosPonude" href="PonudaForma.jsp">Unos ponude</a></li>
                <li><a id="dugmeizmenaPonude" href="#">Izmena Ponude</a></li>
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
                <select name="combo" id="combo" class="dropdown form-control hidden">
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
                                <input class="inputfield form-control input-lg datepicker" type="text" placeholder="Datum" id="datum"
                                       name="datum" required>
                            </div>
                            <div class="form-group form-inline">
                                <label for="select_kupac">Kupac</label>
                                <select id="select_kupac" name="sifraKupca" class="form-control" required>
                                    <option value disabled selected>Kupac</option>
                                </select>
                            </div>
                            <div class="form-group form-inline">
                                <label for="select_radnik">Radnik</label>
                                <select id="select_radnik" name="sifraRadnika" class="form-control" required>
                                    <option selected disabled value>Radnik</option>
                                </select>
                            </div>
                            <div class="form-group form-inline">
                                <label for="isporuka">Isporuka</label>
                                <input class="inputfield form-control input-lg" type="text" placeholder="Isporuka" id="isporuka" name="isporuka">
                            </div>
                            <div class="form-group form-inline">
                                <label for="banka">Banka</label>
                                <input required class="inputfield form-control input-lg" type="text" placeholder="Banka" id="banka" name="banka">
                            </div>
                            <div class="form-group form-inline">
                                <label for="tekuciRacun">Tekući racun</label>
                                <input class="inputfield form-control input-lg" type="text" placeholder="Tekući racun" id="tekuciRacun"
                                       name="tekuciRacun">
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
                                <input class="inputfield form-control input-lg datepicker" type="text" placeholder="Datum prometa"
                                       id="datumPrometa" name="datumPrometa" required>
                            </div>
                            <div class="form-group form-inline">
                                <label for="tipPlacanja">Tip plaćanja</label>
                                <input class="inputfield form-control input-lg" type="text" placeholder="Tip plaćanja" id="tipPlacanja"
                                       name="tipPlacanja">
                            </div>
                        </div>

                        <div class="ponuda_omot">
                            <div class="row centered-form">
                                <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h3 class="panel-title">Dodajte novu stavku ponude</h3>
                                            <h3 class="panel-title hidden">Rad sa stavkom ponude</h3>
                                        </div>
                                        <div class="panel-body">
                                            <div class="artikalform" action="" method="post" role="form">

                                                <div class="form-group">
                                                    <label class="control-label" for="select_SIFRAARTIKLA">Artikal</label>
                                                    <select id="select_SIFRAARTIKLA" name="SIFRAARTIKLA" class="form-control">
                                                        <option value="0" selected>Artikal</option>
                                                    </select>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label" for="kolicina">Količina</label>
                                                    <input type="number" min="1" step="1" name="KOLICINA" id="kolicina"
                                                           class="form-control input-sm" placeholder="Količina">
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label" for="napomenastavke">Napomena</label>
                                                    <input type="text" id="napomenastavke" name="napomenastavke" class="form-control input-sm" placeholder="Napomena stavke">
                                                </div>
                                                <input hidden id="Rbr" type="text" name="Rbr" value="0">
                                                <div class="stavkabuttons">
                                                    <button id="dodajstavku" name="dodajstavku" class="btn-lg btn-info">Dodaj stavku</button>
                                                    <button id="izmenistavku" name="izmenistavku" class="btn-lg btn-success hidden">Izmeni stavku</button>
                                                    <button id="obrisistavku" name="obrisistavku" class="btn-lg btn-danger hidden">Obriši
                                                        stavku</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div>
                                <h3>Stavke ponude</h3>
                                <table id="detalji_ponude" border='1' class='table tablesorter table-striped table-condensed'></table>
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


<%
    String listaArtikala;
    String listaKupaca;
    String listaRadnika;
    String listaPonuda;
    String ponudaJSON;


    PonudaKontroler k = new PonudaKontroler();

    listaPonuda = k.vratiPonude();
    listaArtikala = k.vratiArtikle();
    listaKupaca = k.vratiKupce();
    listaRadnika = k.vratiRadnike();




//    start()
//    popuniArtikle(listaArtikala);
//    popuniKupce(listaKupaca);
//    popuniRadnike(listaRadnika);
//    popuniPonude(listaPonuda);

//    DodajStavku()
//    IzmeniStavku()
//    ObrisiStavku()

//    AzurirajPrikaz()
//    Sacuvaj()


//    popuniPoljaForme(ponudaJSON)
//    odaberiPonudu()
//    izmeni()


%>


<script type="text/javascript">
    $(document).ready(function () {

        aktuelnaPonuda = {};
        stavke = [];

        function vratiPonudu(slected) {
            $.ajax({
                url: "http://localhost:8080/fpis01_war_exploded/ponudakontroler",
                method: "GET",
                data: {
                    'brPonude' : slected
                },
                success:
                    function (data) {
                        popuniPoljaForme(data);
                        console.log(data);
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
        populateComboBox(<% out.println(listaPonuda); %>);

        function populateArtikalComboBox(data) {
            $(data).map(function () {
                $('<option>').val(this.sifraartikla).text(this.nazivartikla).appendTo('#select_SIFRAARTIKLA');
            });
        }
        populateArtikalComboBox(<% out.println(listaArtikala); %>);

        function populateKupacComboBox(data) {
            $(data).map(function () {
                $('<option>').val(this.sifraKupca).text(this.ime).appendTo('#select_kupac');
            });
        }
        populateKupacComboBox(<% out.println(listaKupaca); %>);

        function populateRadnikComboBox(data) {
            $(data).map(function () {
                $('<option>').val(this.sifraRadnika).text(this.ime).appendTo('#select_radnik');
            });
        }
        populateRadnikComboBox(<% out.println(listaRadnika); %>);

        function popuniPoljaForme(ponuda) {
            $('#detalji_ponude').empty();
            stavke = ponuda.Stavke;
            delete ponuda.Stavke;
            $('#ponudaForma').populate(ponuda);
            $('#select_kupac').val(ponuda.sifraKupca).prop('selected', true);
            $('#select_radnik').val(ponuda.sifraRadnika).prop('selected', true);

            if  (!jQuery.isEmptyObject(stavke)) {
                Tablify_stavka(stavke, '#detalji_ponude', 'Rbr');
                $(".azuriraj").click(function (e) {
                    e.preventDefault();

                    var ccid = this.id.split("_")[0];
                    console.log(stavke);
                    console.log('this button id: ' + ccid);

                    for(var i=0;i<stavke.length;i++) {
                        if (stavke[i].Rbr == ccid) {
                            console.log(stavke[i].Rbr);

                            $("#select_SIFRAARTIKLA option").attr('selected', false);
                            $("#select_SIFRAARTIKLA option:contains("+stavke[i].Artikal+")").attr('selected', true);
                            $("#kolicina").val(stavke[i].Kolicina);
                            $("#Rbr").val(stavke[i].Rbr);
                            $("#napomenastavke").val(stavke[i].Napomena);

                            var tmpRbr = "#tr_" + stavke[i].Rbr;
                            $('#detalji_ponude tr').removeClass('aktivnastavka');
                            $(tmpRbr).addClass('aktivnastavka');
                        }
                    }
                });
            }
        }

        $('#combo').change(function () {
            selected = $('#combo').find('option:selected').val();
            if (selected != 0) {
                vratiPonudu(selected);
            }
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

        $('#dugmeizmenaPonude').click(function () {
            $('#combo').toggleClass('hidden');
            $('#updateBbutton').toggleClass('hidden');
            $('#deleteBbutton').toggleClass('hidden');
            $('.panel-title').toggleClass('hidden');
            $('#insertBbutton').toggleClass('hidden');
            $('#izmenistavku').toggleClass('hidden');
            $('#obrisistavku').toggleClass('hidden');
        });

        $( ".datepicker" ).datepicker({dateFormat: 'yy-mm-dd 00:00:00'});

        // Rad sa stavkom

        $("#dodajstavku").click(function (e) {
            e.preventDefault();
            $.ajax({
                url: "http://localhost:8080/fpis01_war_exploded/ponudakontroler",
                method: "POST",
                data: {
                    'radsastavkom': true,
                    'SIFRAARTIKLA': $("#select_SIFRAARTIKLA").val(),
                    'KOLICINA': $("#kolicina").val(),
                    'napomenastavke': $("#napomenastavke").val(),
                    'status': 'insert',
                    'rbr': 0
                },
                success:
                    function () {
                    },
                error:
                    function (e) {
                        console.log(e.responseText);
                    }
            });

            if ( stavke.length == 0) {
                var prvaStavka = [{
                    Artikal: $("#select_SIFRAARTIKLA option:selected").text(),
                    Kolicina: $("#kolicina").val(),
                    Napomena: $("#napomenastavke").val(),
                    Rbr: 1
                }];

                Tablify_stavka(prvaStavka, '#detalji_ponude', 'Rbr');
                $('.azuriraj').addClass('hidden');
                $('.tmpArtikal').show('slow');
                stavke.push('1');
            } else {

                //todo: srediti redne brojeve

                var newRow = '<tr class="tmpArtikal" style="display: none;"><td class="Artikal">' + $("#select_SIFRAARTIKLA option:selected").text() + '</td><td id="4_Rbr" class="Rbr">4</td><td id="4_Kolicina" class="Kolicina">' + $("#kolicina").val() + '</td><td id="4_Napomena" class="Napomena">' + $("#napomenastavke").val() + '</td><td></td></tr>';
                $('#detalji_ponude tbody').append(newRow);
                $('.tmpArtikal').show('slow');
            }

            $("#select_SIFRAARTIKLA").val(0);
            $("#kolicina").val('');
            $("#napomenastavke").val('');
        });

        $("#izmenistavku").click(function (e) {
            e.preventDefault();
            $.ajax({
                url: "http://localhost:8080/fpis01_war_exploded/ponudakontroler",
                method: "POST",
                data: {
                    'radsastavkom' : true,
                    'SIFRAARTIKLA' : $("#select_SIFRAARTIKLA").val(),
                    'KOLICINA' : $("#kolicina").val(),
                    'napomenastavke' :  $("#napomenastavke").val(),
                    'status' : 'update',
                    'rbr' : $("#Rbr").val()
                },
                success:
                    function () {
                    },
                error:
                    function (e) {
                        console.log(e.responseText);
                    }
            });

            // todo: da uzme parametre iz data, uporedi sa redom u tabeli izmeni i zacrveni razlicite
            // todo: deselect na click van polja
            for(var i=0;i<stavke.length;i++) {
                if (stavke[i].Rbr == $("#Rbr").val()) {
                    console.log('redni br stavke za izmenu: ' + stavke[i].Rbr);
                }
            }
        });

        $("#obrisistavku").click(function (e) {
            e.preventDefault();
            $.ajax({
                url: "http://localhost:8080/fpis01_war_exploded/ponudakontroler",
                method: "POST",
                data: {
                    'radsastavkom' : true,
                    'status' : 'delete',
                    'rbr' : $("#Rbr").val()
                },
                success:
                    function () {
                    },
                error:
                    function (e) {
                        console.log(e.responseText);
                    }
            });
            var tmpRbr = "#tr_" + $("#Rbr").val();
            $(tmpRbr).hide( "fade", { direction: "left" }, "slow" );
        });

    });

</script>
<div id="footer" class="">
    <div class="container">
        <p class="">Copyright &copy; 2018 Vojislav Ristivojević, 2016/3079</p>
    </div>
</div>

</body>
</html>
