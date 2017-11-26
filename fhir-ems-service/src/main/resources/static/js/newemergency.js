

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
    
    userId = getUrlParameter('userId');
    console.log(userId);
    orgId = getUrlParameter('orgId');
});

function createEmergency(){

    var orgId = getUrlParameter('orgId');
    var emergencyTitle=$.trim($("#emergencyTitle").val());
    var firstName=$.trim($("#firstName").val());
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
        data.organizationUuid=orgId;
        data = JSON.stringify(data);

        $.ajax({
            url: "../api/emergency/",
            type: "POST",
            contentType: "application/json",
            dataType: "json",
            data: data,
            cache: false,
            success: function (response) {
                alert("Emergency successfully submitted!");
                window.location.href = "dashboard.html?userId="+getUrlParameter('userId')+"&orgId="+getUrlParameter('orgId');

            }
        });
    } else{
        alert("All fields are required and must not be blank");
    }
}