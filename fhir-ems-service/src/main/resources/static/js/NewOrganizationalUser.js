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
    
    orgUuid = getUrlParameter('orgId');
});
function register(){

    var newuser=$('#newuser').val();
	
    var newpass=$('#newpass').val();
	
	var repass=$('#repass').val();
	
	var firstname=$('#firstname').val();
	
	var lastname=$('#lastname').val();
	
	
	if (newpass!==repass){
		window.alert("Password mismatch, please try again");}
	
    else if (newuser !== null && newpass !== null && repass!== null){

        var newUser={};
		newUser.userName=newuser;
        newUser.password=newpass;
		newUser.firstName=firstname;
		newUser.lastName=lastname;
		newUser.organizationUuid=orgUuid;
		
		newUser = JSON.stringify(newUser);
        console.log(newUser);
        $.ajax({
            type: "POST",
            url: '../api/user',
            data: newUser,
            dataType: 'json',
            contentType: "application/json",
            success:function(data) {
                window.alert ("Registration succeed!");
				window.location.href = "dashboard.html?userId="+getUrlParameter("userId");
            }
        });

    }
	else
	{
		window.alert ("Please input username and password!");
	}
}