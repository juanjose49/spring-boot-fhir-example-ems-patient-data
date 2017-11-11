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
    $("#dashboardLink").attr("href","dashboard.html?id="+getUrlParameter("id"))

   var token = getUrlParameter('id');
   console.log(token);

    $.ajax({
        url: "/api/user/"+token,
        cache: false,
        success: function(response){
            $("#welcomeUser").text("Welcome "+response.firstName+ " "+response.lastName);
            orgUuid = response.organizationUuid
            var table = $('#emergenciesTable').DataTable({
                
                        "sAjaxSource": "/api/organization/"+orgUuid+"?verbose=true",
                        "sAjaxDataProp": "emergencies",
                        "orderClasses": false,
                        "order": [[ 3, "asc" ]],
                        "aoColumns": [
                            { "mData": "emergencyUuid" },
                            { "mData": "emergencyTitle" },
                            { "mData": "pickupLocation" },
                            { "mData": "emergencyState" },
                            {
                                mData: "Action",
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

  






});


