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
    $("#dashboardLink").attr("href","dashboard.html?id="+getUrlParameter("id"))
    
   var token = getUrlParameter('emergencyid');
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
            { "mData": "lastName" },
            {
                mData: "Action",
                bSortable: false,
                mRender: function (data, type, row) {
                    return '<a href="patientdetails.html?id='+token+'&patientID='+row.patientID+'" class="btn btn-default btn-sm" role="button">View Patient Details</a>'
                }
            }
        ]
    });

});


