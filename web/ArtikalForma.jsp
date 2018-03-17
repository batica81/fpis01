<%@ page import="com.fpis.test.kontroler.ArtikalKontroler" %>
<%@ page import="org.json.simple.parser.JSONParser" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="org.json.simple.parser.ParseException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp" %>

<%!
    private String listaArtikala;
    private String artikalJSON;
    private ArtikalKontroler k = new ArtikalKontroler();
    private JSONParser parser = new JSONParser();

    private String PrikaziArtikle(String listaArtikala){
        JSONArray artikalArray = null;
        String tempLista = "";
        try {
            artikalArray = (JSONArray) parser.parse(listaArtikala);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (Object artikalObject:artikalArray) {
            JSONObject artikal = (JSONObject) artikalObject;
            tempLista += "<option value="+ artikal.get("sifraartikla") + ">" + artikal.get("nazivartikla") + "</option>\n";
        }
        return tempLista;
    }
%>

<%
    listaArtikala = k.vratiArtikle();
%>

<div class="container artikalforma">
    <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Unos artikla</h3>
                </div>
                <select name="combo" id="combo" class="dropdown form-control hidden">
                    <option selected disabled value>Odaberite artikal za izmenu</option>
                    <% out.print(PrikaziArtikle(listaArtikala)); %>
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

                        <button id="insertBbutton" type="submit" class="btn-lg btn-block btn-info">Unesi artikal</button>
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

        function pronadjiArtikal(sifraArtikla) {
            $.ajax({
                url: "/fpis01_war_exploded/artikalkontroler",
                method: "GET",
                data: {
                    'sifraArtikla' : sifraArtikla
                },
                success:
                    function (artikalJSON) {
                        popuniPoljaForme(artikalJSON);
                    },
                error:
                    function (e) {
                        console.log(e.responseText);
                    }
            });
        }

        function popuniPoljaForme(artikalJSON) {
            $('#artikalForma').populate(artikalJSON);
        }

        $('#combo').change(function () {
            var sifraArtikla = $('#combo').find('option:selected').val();
                pronadjiArtikal(sifraArtikla);
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
    });

</script>

<%@include file="footer.jsp" %>
