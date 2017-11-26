


function authenticate(){

    var username=$('#username').val();
    var password=$('#password').val();

    if (username !== null && password !== null){

        var jsonBody={};
        jsonBody.userName=username;
        jsonBody.password=password;
        jsonBody = JSON.stringify(jsonBody);

        $.ajax({
            type: "POST",
            url: '../api/authentication',
            data: jsonBody,
            headers: { 'User': jsonBody },
            dataType: 'json',
            contentType: "application/json",
            success:function(data) {
                console.log(data.token);
                window.location.href = "dashboard.html?userId="+data.token;
            }
        });

    }
}