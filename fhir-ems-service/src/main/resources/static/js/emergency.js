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
    $("#dashboardLink").attr("href","dashboard.html?userId="+getUrlParameter("userId"));
    
   var emergencyId = getUrlParameter('emergencyId');
   console.log(emergencyId);


    updateTable(emergencyId);



});

function updateTable(emergencyId){

    var orgId = getUrlParameter('orgId');
    var userId = getUrlParameter('userId');

    $.ajax({
        url: "../api/emergency/"+emergencyId,
        cache: false,
        contentType: 'application/json',
        dataType: 'json',
        success: function(data){
            $('#emergencyIdDiv').text(data.emergencyUuid);
            $('#emergencyTitleDiv').text(data.emergencyTitle);
            $('#pickupLocationDiv').text(data.pickupLocation);
            $('#emergencyStateDiv').text(data.emergencyState);


            var emergencyID = data.emergencyUuid;
            var emergencyTitle = data.emergencyTitle;
            var pickupLocation = data.pickupLocation;
            var emergencyState = data.emergencyState;

            $(".emergencyInfoInner").append("<table class='emergencyInfo' cellspacing='10'>");
            var emergencyIDString = "<b>Emergency ID: </b>" + JSON.stringify(emergencyID);
            $(".emergencyInfoInner").append("<tr><td style='padding:0 0 0 0px; font-size: 150%;' class='emergencyInfo'>" + emergencyIDString+ "</td></tr>");
            var emergencyTitleString = "<b>Emergency Title: </b>" + emergencyTitle;
            $(".emergencyInfoInner").append("<tr><td style='padding:0 0 0 0px; font-size: 150%;' class='emergencyInfo'>" + emergencyTitleString + "</td></tr>");
            var pickupLocationString = "<b>Pickup Location: </b>" + pickupLocation;
            $(".emergencyInfoInner").append("<tr><td style='padding:0 0 0 0px; font-size: 150%;' class='emergencyInfo'>" + pickupLocationString + "</td></tr>");
            var emergencyStateString = "<b>Emergency State: </b>" + emergencyState;
            $(".emergencyInfoInner").append("<tr><td style='padding:0 0 0 0px; font-size: 150%;' class='emergencyInfo'>" + emergencyStateString + "</td></tr>");
            $(".emergencyInfoInner").append("</table>");

        }
    });




    var table = $('#emergenciesTable').DataTable({
        "sAjaxSource": "../api/emergency/"+emergencyId+"?verbose=true",
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
                    return '<a href="patientdetails.html?userId='+getUrlParameter('userId')+'&orgId='+getUrlParameter('orgId')+'&emergencyId='+emergencyId+'&patientId='+row.patientUuid+'&fhirUuid='+row.fhirUuid+'" class="btn btn-default btn-sm" role="button">View Patient Details</a>'
                }
            }
        ]
    });

}


