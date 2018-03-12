<%@ page import="com.fpis.test.kontroler.ArtikalKontroler" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="header.jsp" %>

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

//    artikalJSON = k.pronadjiArtikal(1);

//    out.println("<h2>TRAZENI ARTIKAL JE:</h2>");
//    out.println(artikalJSON);
%>

<div class="container artikalforma">
    <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Unos artikla</h3>
                    <h3 class="panel-title hidden">Izmena artikla</h3>
                </div>
                <select name="combo" id="combo" class="dropdown form-control hidden">
                    <option selected disabled value>Odaberite artikal za izmenu</option>
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
        });

        $("#updateBbutton").click(function () {
            $("#stautsinput").val("update");
        });

        $("#deleteBbutton").click(function () {
            $("#stautsinput").val("delete");
        });

        function pronadjiArtikal(sifraArtikla) {
            $.ajax({
                url: "http://localhost:8080/fpis01_war_exploded/artikalkontroler",
                method: "GET",
                data: {
                    'sifraArtikla' : sifraArtikla
                },
                success:
                    function (artikalJSON) {
                        popuniPoljaForme(artikalJSON[0]);
                    },
                error:
                    function (e) {
                        console.log(e.responseText);
                    }
            });
        }

        //TODO: pretvoriti u JSP i preimenovati metode

        function prikaziArtikle(listaArtikala) {
            $(listaArtikala).map(function () {
                $('<option>').val(this.sifraartikla).text(this.nazivartikla).appendTo('#combo');
            });
        }
        prikaziArtikle(<% out.println(listaArtikala); %>);

        function popuniPoljaForme(artikalJSON) {
            $('#artikalForma').populate(artikalJSON);
        }

        $('#combo').change(function () {
            selected = $('#combo').find('option:selected').val();
            if (selected != 0) {
                pronadjiArtikal(selected);
            }
        });

    });

</script>

<%@include file="footer.jsp" %>
</html>
