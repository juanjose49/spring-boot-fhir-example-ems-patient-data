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

function refreshTable(token){

    $.ajax({
        // get user
        url: "/api/user/"+token,
        cache: false,
        success: function(response){
            // if user found, render table and welcome message
            $("#welcomeUser").text("Welcome "+response.firstName+ " "+response.lastName);
            orgUuid = response.organizationUuid;
            var table = $('#emergenciesTable').DataTable({
                "sAjaxSource": "/api/organization/"+orgUuid+"?verbose=true",
                "sAjaxDataProp": "emergencies",
                "orderClasses": false,
                "order": [[ 3, "asc" ]],
                "destroy":true,
                "aoColumns": [
                    { "mData": "emergencyUuid" },
                    { "mData": "emergencyTitle" },
                    { "mData": "pickupLocation" },
                    {
                        mData: "emergencyState",
                        bSortable: false,
                        render: function (data, type, row, meta){
                            var $select = $("<select  id='emergency"+row.emergencyUuid+"'><option value='CLOSED'>CLOSED</option><option value='ACTIVE'>ACTIVE</option><option value='PENDING'>PENDING</option>");
                            $select.find('option[value="'+data+'"]').attr('selected', 'selected');
                            $('#emergency'+row.emergencyUuid).on('change', function(){
                                console.log(this.value);
                                sendUpdate(token, row.emergencyUuid, this.value)
                            });
                            return $select[0].outerHTML;
                        }
                    },
                    {
                        mData: "View Emergency",
                        bSortable: false,
                        mRender: function (data, type, row) {
                            return '<a href="emergency.html?id='+token+'&emergencyid='+row.emergencyUuid+'" class="btn btn-default btn-sm" role="button">Open</a>'
                        }
                    }
                ],
                "createdRow": function( row, data, dataIndex ) {

                    if ( data.emergencyState == "CLOSED" ) {
                        $(row).css( "background-color", "#ff4444" );

                    } else if (data.emergencyState == "PENDING"){
                        $(row).css( "background-color", "#ffbb33" );
                    } else if (data.emergencyState == "ACTIVE"){
                        $(row).css( "background-color", "#00C851" );

                    }
                },

            });
            $('a.createEmergency').on('click', function (e) {
                $(this).attr("href", "/newemergency.html?id="+token+"&orgId="+orgUuid);
            });
        }
    });

}

function getEmergency(token, id){

    var id = id;
    var json;
    //get all emergencies
    $.ajax({
        dataType: "json",
        url: "/api/organization/"+token+"?verbose=true",
        async:false,
        success: function (data) {
            console.log(data);
            for (emergency in data.emergencies){
                if (data.emergencies[emergency].emergencyUuid == id){
                    json = data.emergencies[emergency];
                }
            }
        }
    });
    return json;

}

function sendUpdate(token, emergencyUuid, emergencyStatus){
    var token = token;
    var emergencyUuid = emergencyUuid;
    var emergencyStatus = emergencyStatus;

    // get specific emergency
    var emergencyObject = getEmergency(token, emergencyUuid);
    // set new emergency state
    emergencyObject.emergencyState = emergencyStatus;


    //serialize
    emergencyObject = JSON.stringify(emergencyObject);


    $.ajax({
        dataType: "json",
        url: "/api/emergency/",
        contentType: "application/json",
        type: 'PUT',
        data: emergencyObject,
        success: function (data) {
            refreshTable(token);
        }
    });

}


$(document).ready(function () {


    $("#dashboardLink").attr("href","dashboard.html?id="+getUrlParameter("id"));
    var token = getUrlParameter('id');

    refreshTable(token);

});

