$('#email').keyup(function () {
    $('#password').val($(this).val()+"@pms");
});

$( document ).ready(function() {

    var pageURL = $(location).attr("href");

    if(pageURL == "http://localhost:3000/request.html") {

        location.href = "sitemanagerHome.html";

        return;

    }

    $('#back').click(function () {
        location.href = "sitemanagerHome.html";
    });


    $('#note').hide();
    $('#noteLabel').hide();
    $('#price').hide();

    $('#order_status').change(function() {
        if (this.value == 'Cancelled') {
            $('#note').show();
            $('#noteLabel').show();
        } else if(this.value == 'Rejected') {
            $('#note').show();
            $('#noteLabel').show();
        } else {
            $('#note').hide();
            $('#noteLabel').hide();
        }

    });



    // ADD NEW USER
    $("#managerRequest").submit(function (event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();
        ajaxPostNewRequest();
    });

    function ajaxPostNewRequest() {

        // PREPARE FORM DATA
        var formData = {
            orderby: $("#Requester_id").val(),
            site: $("#site_name").val(),
            manager: $("#manager_name").val(),
            date: $("#Order_date").val(),
            requiredate: $("#require_date").val(),
            item: $("#item").val(),
            qty: $("#qty").val(),
            description: $("#description").val(),
            contactnum: $("#contact").val(),
            supplier: $("#Supplier_Name").val(),
            status: $("#order_status").val(),
            note: $("#note").val()

        }


        // DO POST
        $.ajax({
            type: "POST",
            contentType: "application/json; charset=utf-8",
            url: "/sitemanager", //window.location +"sitemanager",
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function (res) {
                if (res.error) {
                    swal({title: "Error", text: res.error, type: "error"});
                }
                else {
                    swal({title: "Success", text: "Your Account Has Been Created. Please Login", type: "success"});

                }
                // swal({title:"Success", text:"Your Account Has Been Created. Please Login", type:"success"});
                // resetData();
            }
            // error : function(e) {
            //     swal({title:"Error", text:"Error"+e, type:"error"});
            // }
        });

    }
});

