$(document).ready(function(){

    var userRole = localStorage.getItem('role');

    if (userRole == null || userRole != "Site Manager") {

        location.href = "/";

        return;

    }
    var useremail = localStorage.getItem('email');
    ajaxGetRequester(useremail);

    getOrders();

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

    function getOrders() {

        $.ajax({
            type: "GET",
            url: "/sitemanager/user/" + useremail,
            success: function(result) {

                $('#orders').DataTable({
                    "data" : result,
                    "columns" : [
                        {"defaultContent" : "<button id='viewRequest' class='btn btn-success' > View </button>"},
                        { "data" : "id" },
                        { "data" : "orderby" },
                        { "data" : "item" },
                        { "data" : "requiredate" },
                        { "data" : "status" }
                    ],
                    "bDestroy": true
                });

            }
        });

        $('#orders').on('click', '#viewRequest', function () {
            var table = $('#orders').DataTable();2

            var data = table.row($(this).closest('td, li')).data();

            localStorage.setItem('id', data["id"]);

            $("#body").load('/manageRequest.html'), function () {
                $.getScript('/js/viewJS/manageRequest.js');
            }

        });

    }

});