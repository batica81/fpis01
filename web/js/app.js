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
        tableRow += '<tr>';

        tmp_key = turk[primary_key];
        tmp_brponude = turk['BrPonude'];


        for(var key in turk){
            tableRow += '<td id="'+tmp_key+'_'+key+'" class="'+ key +'">' + turk[key] + '</td>';

        }
        tableRow += '<td><a class="btn btn-info" href="ponuda.php?br_ponude='+tmp_brponude+'">Ažuriraj ovu stavku<a></td>';
        tableRow += '</tr>';
        tmp_keys_array.push(tmp_key);

    }

    $(table_id).append(tableHeader);
    $(table_id).append('<tbody>');
    $(table_id).append(tableRow);
    $(table_id).append('</tbody>');
    $(table_id).tablesorter();



} // end Tablify_stavka