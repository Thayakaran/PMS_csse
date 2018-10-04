$(document).ready(function() {

    $('#note').hide();
    $('#noteLabel').hide();

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
    var id;

    $("#managependingRequest").submit(function(event){
        event.preventDefault();
         id = $("#Request_id").val();
        console.log(id);

        ajaxGetRequestId(id);
    });


    // DO GET
    function ajaxGetRequestId(id){
        $.ajax({
            type : "GET",
            url : "/sitemanager/" + id,
            success: function(result){
                if(result){
                    $("#Requester_id").val(result.orderby),
                        $("#site_name").val(result.site),
                        $("#manager_name").val(result.manager),
                        $("#Order_date").val(result.date),
                        $("#require_date").val(result.requiredate),
                        $("#item").val(result.item),
                        $("#qty").val(result.qty),
                        $("#description").val(result.description),
                        $("#contact").val(result.contactnum),
                        $("#order_status").val(result.status),
                        $("#note").val(result.note)

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

                    console.log("Success: ", result);
                }else{
                    $("#Request_id").val("Request not found");
                    console.log("Fail: ", result);
                }
            },
            error : function(e) {
                $("#Request_id").val("Request not found");
                console.log("ERROR: ", e);
            }
        });
    }


    // UPDATE EXISTING Request
    $("#managerRequest").submit(function(event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();
        ajaxPostUpdateRequest(id);
    });

    function ajaxPostUpdateRequest(id) {

        // PREPARE FORM DATA
        var formData = {
            supplier: $("#Supplier_Name").val(),
            status: $("#order_status").val(),
            note: $("#note").val()

        }

        // DO PUT
        $.ajax({
            type: "PUT",
            contentType: "application/json; charset=utf-8",
            url: "/sitemanager/" + id, //window.location +"users",
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function (res) {
                if (res.error) {
                    swal({title: "Error", text: res.error, type: "error"});
                }
                else {
                    swal({title: "Success", text: "Your Account Has Been Created. Please Login", type: "success"});
                    resetUpdateData();
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
