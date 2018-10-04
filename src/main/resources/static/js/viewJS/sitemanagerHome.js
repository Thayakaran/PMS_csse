$(document).ready(function(){

    var userRole = localStorage.getItem('role');

    if (userRole == null || userRole != "Site Manager") {

        location.href = "/";

        return;

    }
    var useremail = localStorage.getItem('email');
    ajaxGetRequester(useremail);

    function ajaxGetRequester(useremail) {
        $.ajax({
            type : "GET",
            url : "/sitemanager/user/" + useremail,
            success: function(result){
                if(result) {
                        $("#userwelcome, #username").html(result["userName"]),
                        console.log("Success: ", result);

                }
            },
            error : function(e) {
                $("#Supplier_Name").val("User not found");
                console.log("ERROR: ", e);
            }
        });

    }

    $("#logout1, #logout2").click(function () {
        localStorage.clear();
        location.href = "/";
    });
    //view request
    $('#viewRequest').click(function () {
        $("#body").load('/sitemanagerHome.html'), function() {
            $.getScript('/js/viewJS/viewRequest.js');
        }
    });

    //request
    $('#Request').click(function () {
        $("#body").load('/request.html'), function() {
                 $.getScript('/js/viewJS/request.js');
           }
    });

    //request
    $('#manageRequest').click(function () {
        $("#body").load('/manageRequest.html'), function () {
            $.getScript('/js/viewJS/manageRequest.js');
        }
    });
});