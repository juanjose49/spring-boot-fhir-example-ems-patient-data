var token = null;

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
    token = getUrlParameter('id');
    console.log(token);

});

function createEmergency(){

    console.log('am I being called? ');

    var emergencyTitle=$.trim($("#emergencyTitle").val());
    var firstName=$.trim($("#lastName").val());
    var lastName=$.trim($("#lastName").val());
    var pickupLocation =$.trim($("#pickupLocation").val());

    if(emergencyTitle.length>0 && firstName.length > 0 && lastName.length > 0 && pickupLocation.length > 0) {
        var data = {};

        data.emergencyTitle=emergencyTitle;
        data.pickupLocation=pickupLocation;

        //create patient object
        var patient = {};
        patient.firstName=firstName;
        patient.lastName=lastName;
        data.patient=patient;
        data.organizationUuid=token;
        data = JSON.stringify(data);

        $.ajax({
            url: "/api/emergency/",
            type: "POST",
            contentType: "application/json",
            dataType: "json",
            data: data,
            cache: false,
            success: function (response) {
                alert("Emergency successfully submitted!");
                window.location.href = "dashboard.html?id="+token;

            }
        });
    }
}