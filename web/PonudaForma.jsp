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

<select name="combo" id="combo" class="form-control 5hidden">
    <option value="0" selected>Odaberite ponudu za izmenu</option>
</select>

<form id="ponudaForma" method="post" action="ponudakontroler">
    <input class="inputfield" type="text" placeholder="" name="brPonude">
    <input class="inputfield" type="text" placeholder="" name="datum">
    <input class="inputfield" type="text" placeholder="" name="sifraKupca">
    <input class="inputfield" type="text" placeholder="" name="sifraRadnika">
    <input class="inputfield" type="text" placeholder="" name="isporuka">
    <input class="inputfield" type="text" placeholder="" name="banka">
    <input class="inputfield" type="text" placeholder="" name="tekuciRacun">
    <input class="inputfield" type="text" placeholder="" name="uslovi">
    <input class="inputfield" type="text" placeholder="" name="napomena">
    <input class="inputfield" type="text" placeholder="" name="validnost">
    <input class="inputfield" type="text" placeholder="" name="pozivNaBroj">
    <input class="inputfield" type="text" placeholder="" name="mesto">
    <input class="inputfield" type="text" placeholder="" name="datumPrometa">
    <input class="inputfield" type="text" placeholder="" name="tipPlacanja">
    <input class="inputfield" type="text" placeholder="" name="Stavke">
    <input class="inputfield" type="text" placeholder="" name="status">

</form>

<script type="text/javascript">
    $(document).ready(function () {


        function vratiArtikle() {
            $.ajax({
                url: "http://localhost:8080/fpis01_war_exploded/ponudakontroler",
                method: "GET",
                success:
                    function (data) {
                        populateComboBox(data);
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

        function popuniFormu(selected) {
            listaArtikala.forEach( function (artikal) {
                if (artikal.BrPonude == selected){
                    $('#ponudaForma').populate(artikal);
                }
            });
        }

        vratiArtikle();

        $('#combo').change(function () {
            selected = $('#combo').find('option:selected').val();
            popuniFormu(selected);
        });



    });

</script>
</body>
</html>
