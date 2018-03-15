//Util

function Tablify_stavka(data, table_id, primary_key){

    var tableRow;
    var tableHeader = '<thead>';
    var keynames_array = [];
    var tmp_keys_array = [];

    for (var keyName in data[0]){
        tableHeader += '<th>' + keyName + '</th>';
        keynames_array.push(keyName);
    }

    tableHeader += '<th>Ažuriraj stavku</th>';
    tableHeader += '</thead>';

    for(var i=0;i<data.length;i++){
        var turk = data[i];
        tmp_key = turk[primary_key];
        tmp_brponude = turk['BrPonude'];

        tableRow += '<tr id="tr_'+tmp_key+'">';

        for(var key in turk){
            tableRow += '<td id="'+tmp_key+'_'+key+'" class="'+ key +'">' + turk[key] + '</td>';

        }
        tableRow += '<td class="center"><a id="'+tmp_key+'_btn" class="azuriraj btn btn-info" href="#">Ažuriraj ovu stavku<a></td>';
        tableRow += '</tr>';
        tmp_keys_array.push(tmp_key);
    }

    $(table_id).append(tableHeader);
    $(table_id).append('<tbody>');
    $(table_id).append(tableRow);
    $(table_id).append('</tbody>');
    $(table_id).tablesorter();
} // end Tablify_stavka

Array.prototype.diff = function (a) {
    return this.filter(function (i) {
        return a.indexOf(i) === -1;
    });
};

//Init

$(document).ready(function () {

    $('#navbar a').click(function () {
        sessionStorage.setItem("clicked", this.id);
    });

    if ( sessionStorage.getItem("clicked") == "dugmeizmena") {
        $('.artikalforma #combo').removeClass('hidden');
        $('.artikalforma .panel-title').text('Izmena artikla');
        $('.artikalforma #updateBbutton').removeClass('hidden');
        $('.artikalforma #deleteBbutton').removeClass('hidden');
        $('.artikalforma #insertBbutton').addClass('hidden');
    };

    if ( sessionStorage.getItem("clicked") == "dugmeizmenaPonude") {
        $('.ponudaforma #combo').removeClass('hidden');
        $('.ponudaforma #updateBbutton').removeClass('hidden');
        $('.ponudaforma #deleteBbutton').removeClass('hidden');
        $('.ponudaforma .panel-title').text('Izmena ponude');
        $('.stavka').text('Rad sa stavkom ponude');
        $('.ponudaforma #insertBbutton').addClass('hidden');
        $('.ponudaforma #izmenistavku').removeClass('hidden');
        $('.ponudaforma #obrisistavku').removeClass('hidden');
    };

    $('.inputfield').val('');
    $( ".datepicker" ).datepicker({dateFormat: 'yy-mm-dd 00:00:00'});

});