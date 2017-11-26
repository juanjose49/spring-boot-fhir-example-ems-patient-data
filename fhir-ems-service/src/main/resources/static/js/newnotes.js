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
    $("#dashboardLink").attr("href","dashboard.html?userId="+getUrlParameter("userId"))
    
    token = getUrlParameter('id');
    console.log(token);
    patientUuid = getUrlParameter('patientID');
	console.log(patientUuid);
});


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