<%@ page import="com.fpis.test.kontroler.ArtikalKontroler" %>
<%@ page import="org.json.simple.parser.JSONParser" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="org.json.simple.JSONArray" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp" %>

<%!
    String listaArtikala;
    String artikalJSON;
    ArtikalKontroler k = new ArtikalKontroler();

    JSONParser parser = new JSONParser();



    //    popuniPoljaForme(artikalJSON)

    //    PronadjiArtikal(SifraArtikla)
    //    odaberiArtikal(SifraArtikla)
    //    start()

    //    PrikaziArtikle(listaArtikala)

    //    Sacuvaj()
    //    izmeni()


//    out.print(listaArtikala);

//    artikalJSON = k.pronadjiArtikal(1);

//    out.println("<h2>TRAZENI ARTIKAL JE:</h2>");
//    out.println(artikalJSON);
%>

<%
    listaArtikala = k.vratiArtikle();


    JSONArray artikalArray = (JSONArray) parser.parse(listaArtikala);

    String aa = ( "<option value="+((JSONObject)artikalArray.get(0)).get("sifraartikla") + ">" + ((JSONObject)artikalArray.get(0)).get("nazivartikla") + "</option>");

//    for (:
//         ) {
//
//    }
//    artikalArray.size()
//
//
//
//    for (Object artikalRaw:listaArtikala) {
//    JSONObject obj = new JSONObject();
//    ArtikalEntity artikal = (ArtikalEntity) artikalRaw;
//    obj.put("jedinicamere", artikal.getJedinicamere());
//    obj.put("opisartikla", artikal.getOpisartikla());
//    obj.put("nazivartikla", artikal.getNazivartikla());
//    obj.put("sifraartikla", artikal.getSifraartikla());
//    obj.put("cena", artikal.getCena());
//    arr.add(obj);
//    }
//    return String.valueOf(arr);



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
                    <% out.println(aa); %>
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

        //TODO: pretvoriti u JSP
        <%--function prikaziArtikle(listaArtikala) {--%>
            <%--$(listaArtikala).map(function () {--%>
                <%--$('<option>').val(this.sifraartikla).text(this.nazivartikla).appendTo('#combo');--%>
            <%--});--%>
        <%--}--%>
        <%--prikaziArtikle(<% out.println(listaArtikala); %>);--%>

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

<%!

//    TEST
    public String getQuarter(int i){
        String quarter;
        switch(i){
            case 1: quarter = "Winter";
                break;

            case 2: quarter = "Spring";
                break;

            case 3: quarter = "Summer I";
                break;

            case 4: quarter = "Summer II";
                break;

            case 5: quarter = "Fall";
                break;

            default: quarter = "ERROR";
        }

        return quarter;
    }

%>


<%@include file="footer.jsp" %>
