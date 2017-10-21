


function authenticate(){

    console.log("hey imn here!");

    var username=$('#username').val();
    var password=$('#username').val();

    if (username !== null && password !== null){

        var jsonBody={};
        jsonBody.userName=username;
        jsonBody.password=password;

        $.ajax({
            type: "POST",
            url: '/api/authentication',
            data: jsonBody,
            dataType: 'json',
            contentType: "application/json",
            success:function(data) {
                alert(data);
                console.log(data);
            }
        });

    }
}