
<%@ page import="com.fpis.test.kontroler.PonudaKontroler" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%@include file="header.jsp" %>

<div class="container ponudaforma">
    <div class="row centered-form">
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Unos ponude</h3>
                    <h3 class="panel-title hidden">Izmena ponude</h3>
                </div>
                <select name="combo" id="combo" class="dropdown form-control hidden">
                    <option selected disabled value>Odaberite ponudu za izmenu</option>
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
                                            <h3 class="stavka panel-title">Dodajte novu stavku ponude</h3>
                                        </div>
                                        <div class="panel-body">
                                            <div class="artikalform" action="" method="post" role="form">

                                                <div class="form-group">
                                                    <label class="control-label" for="select_SIFRAARTIKLA">Artikal</label>
                                                    <select id="select_SIFRAARTIKLA" name="SIFRAARTIKLA" class="form-control">
                                                        <option selected disabled value>Artikal</option>
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

        var stavke = [];

        // Rad sa ponudom
        function pronadjiPonudu(brPonude) {
            $.ajax({
                url: "http://localhost:8080/fpis01_war_exploded/ponudakontroler",
                method: "GET",
                data: {
                    'brPonude' : brPonude
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

        function popuniPonude(listaPonuda) {
            $(listaPonuda).map(function () {
                $('<option>').val(this.BrPonude).text('Br. ' + this.BrPonude +' - '+ this.banka).appendTo('#combo');
            });
        }
        popuniPonude(<% out.println(listaPonuda); %>);

        function popuniArtikle(listaArtikala) {
            $(listaArtikala).map(function () {
                $('<option>').val(this.sifraartikla).text(this.nazivartikla).appendTo('#select_SIFRAARTIKLA');
            });
        }
        popuniArtikle(<% out.println(listaArtikala); %>);

        function popuniKupce(listaKupaca) {
            $(listaKupaca).map(function () {
                $('<option>').val(this.sifraKupca).text(this.ime).appendTo('#select_kupac');
            });
        }
        popuniKupce(<% out.println(listaKupaca); %>);

        function popuniRadnike(listaRadnika) {
            $(listaRadnika).map(function () {
                $('<option>').val(this.sifraRadnika).text(this.ime).appendTo('#select_radnik');
            });
        }
        popuniRadnike(<% out.println(listaRadnika); %>);

        function popuniPoljaForme(ponudaJSON) {
            $('#detalji_ponude').empty();
            stavke = ponudaJSON.Stavke;
            delete ponudaJSON.Stavke;
            $('#ponudaForma').populate(ponudaJSON);
            $('#select_kupac').val(ponudaJSON.sifraKupca).prop('selected', true);
            $('#select_radnik').val(ponudaJSON.sifraRadnika).prop('selected', true);

            if  (stavke.length != 0) {
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
            } else {
                $('#detalji_ponude thead').remove();
            }
        }

        $('#combo').change(function () {
            selected = $('#combo').find('option:selected').val();
            if (selected != 0) {
                pronadjiPonudu(selected);
            }
        });

        $("#insertBbutton").click(function () {
            $("#stautsinput").val("insert");
        });

        $("#updateBbutton").click(function () {
            $("#stautsinput").val("update");
        });

        $("#deleteBbutton").click(function () {
            $("#stautsinput").val("delete");
        });

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
                    'unosponude': ($('#combo').hasClass('hidden'))? true : false
                },
                success:
                    function () {
                    },
                error:
                    function (e) {
                        console.log(e.responseText);
                    }
            });

            // prva stavka
            if ( stavke.length == 0) {
                var prvaStavka = [{
                    Artikal: $("#select_SIFRAARTIKLA option:selected").text(),
                    Rbr: 1,
                    Kolicina: $("#kolicina").val(),
                    Napomena: $("#napomenastavke").val()
                }];

                Tablify_stavka(prvaStavka, '#detalji_ponude', 'Rbr');
                $('.azuriraj').addClass('hidden');
                $('.tmpArtikal').show('slow');
                stavke = prvaStavka;
            } else {

                // dodeli redni broj
                var postojeciRbr = [];
                var moguciRbr = [];

                for (var j=0; j < stavke.length; j++ ) {
                    postojeciRbr.push(stavke[j].Rbr);
                }

                for (var k=0; k < postojeciRbr.length + 1; k++ ) {
                    moguciRbr.push(k+1);
                }

                var noviRbr = moguciRbr.diff(postojeciRbr)[0];

                var novaStavka = {
                    Artikal: $("#select_SIFRAARTIKLA option:selected").text(),
                    Rbr: noviRbr,
                    Kolicina: $("#kolicina").val(),
                    Napomena: $("#napomenastavke").val()
                };

                var newRow = '<tr class="tmpArtikal" style="display: none;"><td class="Artikal">' + novaStavka.Artikal + '</td><td class="Rbr">'+ novaStavka.Rbr +'</td><td class="Kolicina">' + novaStavka.Kolicina + '</td><td class="Napomena">' + novaStavka.Napomena + '</td><td></td></tr>';
                $('#detalji_ponude tbody').append(newRow);
                $('.tmpArtikal').show('slow');
                stavke.push(novaStavka);
            }

            $("#select_SIFRAARTIKLA").val(0);
            $("#kolicina").val('');
            $("#napomenastavke").val('');
            $('#detalji_ponude').tablesorter();
            $('#detalji_ponude').tablesorter();
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

            for(var i=0;i<stavke.length;i++) {
                if (stavke[i].Rbr == $("#Rbr").val()) {
                    var tmpRbr = "#tr_" + stavke[i].Rbr;
                    $(tmpRbr).removeClass('aktivnastavka');
                    if ($("#kolicina").val() !=  stavke[i].Kolicina) {
                        $('#'+stavke[i].Rbr+'_Kolicina').addClass('changed').text($("#kolicina").val());
                    }
                    if ($("#napomenastavke").val() !=  stavke[i].Napomena) {
                        $('#'+stavke[i].Rbr+'_Napomena').addClass('changed').text($("#napomenastavke").val());
                    }
                    if ($("#select_SIFRAARTIKLA option:selected").text() !=  stavke[i].Artikal) {
                        $('#'+stavke[i].Rbr+'_Artikal').addClass('changed').text($("#select_SIFRAARTIKLA option:selected").text());
                    }
                }
            }

            $("#select_SIFRAARTIKLA").val(0);
            $("#kolicina").val('');
            $("#napomenastavke").val('');
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

            $("#select_SIFRAARTIKLA").val(0);
            $("#kolicina").val('');
            $("#napomenastavke").val('');
        });

        $( ".datepicker" ).datepicker({dateFormat: 'yy-mm-dd 00:00:00'});
    });

</script>

<%@include file="footer.jsp" %>

</html>
