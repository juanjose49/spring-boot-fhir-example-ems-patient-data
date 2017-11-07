function register(){

    var newuser=$('#newuser').val();
	console.log(newuser);
    var newpass=$('#newpass').val();
	console.log(newpass);
	var repass=$('#repass').val();
	console.log(repass);
	var firstname=$('#firstname').val();
	console.log(firstname);
	var lastname=$('#lastname').val();
	var orgname=$('#organization').val();
	
	
	
    if (newuser !== null && newpass !== null){

        var newUser={};
		var organization = {};
		organization.name= orgname;
        newUser.userName=newuser;
        newUser.password=newpass;
		newUser.firstName=firstname;
		newUser.lastName=lastname;
		
		newUser.organization=organization;
		newUser = JSON.stringify(newUser);
        console.log(newUser);
        $.ajax({
            type: "POST",
            url: '/api/user',
            data: newUser,
            dataType: 'json',
            contentType: "application/json",
            success:function(data) {
                window.alert ("Registration succeed!");
            }
        });

    }
}