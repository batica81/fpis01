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
    <script type="text/javascript" src="js/jquery.populate.js"></script>
    <script type="text/javascript" src="js/app.js"></script>
    <style>
      .hidden{
        display: none;
      }
    </style>
    <title>FPIS Aplikacija</title>
  </head>
  <body>
  <h2>FPIS Aplikacija</h2>


<button id="dugmeunos">Unos artikla</button>
<button id="dugmeizmena">Izmena artikla</button>

  <select name="combo" id="combo" class="hidden">
    <option value="0" selected>Odaberite artikal za izmenu</option>
  </select>

  <form id="artikalForma" method="post" action="artikalkontroler">
    <input class="inputfield" type="text" placeholder="Jedinica mere" name="jedinicamere">
    <input class="inputfield" type="text" placeholder="Opis artikla" name="opisartikla">
    <input class="inputfield" type="text" placeholder="Naziv artikla" name="nazivartikla">
    <input hidden id="sifraartikla" type="text" name="sifraartikla">
    <input hidden id="stautsinput" type="text" name="status">

    <button id="insertBbutton" type="submit">Unesi artikal</button>
    <button id="updateBbutton" type="submit" class="hidden">Izmeni artikal</button>
    <button id="deleteBbutton" type="submit" class="hidden">Obrisi artikal</button>
  </form>

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

        function vratiArtikle() {
            $.ajax({
                url: "http://localhost:8080/fpis01_war_exploded/artikalkontroler",
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
                $('<option>').val(this.sifraartikla).text(this.nazivartikla).appendTo('#combo');
            });
        }

        function popuniFormu(selected) {
            listaArtikala.forEach( function (artikal) {
                if (artikal.sifraartikla == selected){
                    $('#artikalForma').populate(artikal);
                }
            });
        }

        vratiArtikle();

        $('#combo').change(function () {
              selected = $('#combo').find('option:selected').val();
              popuniFormu(selected);
          });

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


  </body>

  <form method="get" action="ponudakontroler">
    <button type="submit">Izlistaj sve ponude</button>
  </form>

  </body>
</html>
