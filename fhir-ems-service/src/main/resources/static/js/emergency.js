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
    $("#dashboardLink").attr("href","dashboard.html?userId="+getUrlParameter("id")+"orgID="+getUrlParameter("orgId"));
    
   var emergencyId = getUrlParameter('emergencyId');
   console.log(emergencyId);

    $.ajax({
        url: "/api/user/"+emergencyId,
        cache: false,
        success: function(response){
            $("#welcomeUser").text("Welcome "+response.firstName+ " "+response.lastName);

        }
    });

    updateTable(emergencyId);


});

function updateTable(emergencyId){
    var table = $('#emergenciesTable').DataTable({
        "sAjaxSource": "/api/emergency/"+emergencyId+"?verbose=true",
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
                    return '<a href="patientdetails.html?userId'+getUrlParameter('userId')+'&orgId='+getUrlParameter('orgId')+'&emergencyId='+emergencyId+'&patientId='+row.patientUuid+'" class="btn btn-default btn-sm" role="button">View Patient Details</a>'
                }
            }
        ]
    });

}


