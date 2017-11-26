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

var token = null;

$(document).ready(function () {
    $("#dashboardLink").attr("href","dashboard.html?userId="+getUrlParameter("userId"))
    updatePatientDetailsTable()
    updateMedicationsTable()
    
});

function updatePatientDetailsTable(){
    
        var patientId = getUrlParameter('patientId');
    
        $.ajax({
            url: "/api/patient/"+patientId,
            cache: false,
            contentType: 'application/json',
            dataType: 'json',
            success: function(patient){
                console.log(patient)

                var patientUuid = patient.patientUuid
                var fhirUuid = patient.fhirUuid
                var firstName = patient.firstName
                var lastName = patient.lastName
                var addressLine = patient.address.addressLine
                var city = patient.address.city
                var country = patient.address.country
                var state = patient.address.state
                var zip = patient.address.zip
                
                $(".patientDetails").append("<table class='patientDetailsInfo' cellspacing='10'>");
                $(".patientDetails").append("<tr><td style='padding:0 0 0 0px; font-size: 150%;' class='patientDetailsInfo'><b>Patient ID: </b>" + patientUuid+ "</td></tr>");
                $(".patientDetails").append("<tr><td style='padding:0 0 0 0px; font-size: 150%;' class='patientDetailsInfo'><b>FHIR ID: </b>" + fhirUuid+ "</td></tr>");
                $(".patientDetails").append("<tr><td style='padding:0 0 0 0px; font-size: 150%;' class='patientDetailsInfo'><b>First Name: </b>" + firstName+ "</td></tr>");
                $(".patientDetails").append("<tr><td style='padding:0 0 0 0px; font-size: 150%;' class='patientDetailsInfo'><b>Last Name: </b>" + lastName+ "</td></tr>");
                $(".patientDetails").append("<tr><td style='padding:0 0 0 0px; font-size: 150%;' class='patientDetailsInfo'><b>Home City: </b>" + city+ "</td></tr>");
                $(".patientDetails").append("<tr><td style='padding:0 0 0 0px; font-size: 150%;' class='patientDetailsInfo'><b>Home Country: </b>" + country+ "</td></tr>");
                $(".patientDetails").append("<tr><td style='padding:0 0 0 0px; font-size: 150%;' class='patientDetailsInfo'><b>Home State: </b>" + state+ "</td></tr>");
                $(".patientDetails").append("<tr><td style='padding:0 0 0 0px; font-size: 150%;' class='patientDetailsInfo'><b>Home Zip: </b>" + zip+ "</td></tr>");
                $(".patientDetails").append("</table>");
    
            }
        });
    }

    function updateMedicationsTable(){
        
            var fhirUuid = getUrlParameter('fhirUuid');
            var table = $('#medicationsTable').DataTable({
                "sAjaxSource": "/api/patient/"+fhirUuid+"/medications",
                "sAjaxDataProp": "medications",
                "orderClasses": false,
                "order": [[ 0, "asc" ]],
                "aoColumns": [
                    { "mData": "medicationUuid" },
                    { "mData": "name" },
                    { "mData": "conditionName" },
                    { "mData": "description" },
                    { "mData": "status" }
                ]
            });
        
        }










function response(){
	//get original patient json data
	if (patientUuid !== null){
		var originalPatient;
		
		$.ajax({
		dataType: "json",
        url: "/api/patient/"+patientUuid,
        async:false,
        success: function (data) {
            console.log(data);
			originalPatient = data;
			
        }
    });
      
	}
	
	var originalNotes = originalPatient.patientNotes;
	console.log(originalNotes);
    
	var newNotes=$('#notes').val();
		
    if (patientUuid !== null && originalNotes !== newNotes){

		//update patient notes
	    originalPatient.patientNotes = newNotes;
        	
		
		originalPatient = JSON.stringify(originalPatient);
        console.log(originalPatient);
        $.ajax({
		    type: "PUT",
            url: '/api/patient/',
            data: originalPatient,
            dataType: 'json',
            contentType: "application/json",
            success:function(data) {
                window.alert ("Patient Notes Updated!");
				//window.location.href = "patientdetails.html?id="+token+"&patientID="+patientUuid;
            }
        });

    }
	else
	{
		//window.location.href = "patientdetails.html?id="+token+"&patientID="+patientUuid;
		window.alert ("No update made!");
	}
}