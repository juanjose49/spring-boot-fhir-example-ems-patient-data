var getUrlParameter = function getUrlParameter(sParam) {
    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : sParameterName[1];
        }
    }
};





$(document).ready(function () {
   var token = getUrlParameter('id');
   console.log(token);

    $.ajax({
        url: "/api/user/"+token,
        cache: false,
        success: function(response){
            $("#welcomeUser").text("Welcome "+response.firstName+ " "+response.lastName);

        }
    });



    var table = $('#emergenciesTable').DataTable({
        "sAjaxSource": "/api/emergency/"+token+"?verbose=true",
        "sAjaxDataProp": "possiblePatients",
        "orderClasses": false,
        "order": [[ 0, "asc" ]],
        "aoColumns": [
            { "mData": "patientUuid" },
            { "mData": "firstName" },
            { "mData": "lastName" }
        ]
    });

});


