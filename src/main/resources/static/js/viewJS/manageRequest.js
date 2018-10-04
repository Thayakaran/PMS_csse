$(document).ready(function() {
    var pageURL = $(location).attr("href");

    if(pageURL == "http://localhost:3000/manageRequest.html") {

        location.href = "sitemanagerHome.html";

        return;

    }


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
    $('#back').click(function () {
        location.href = "sitemanagerHome.html";
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
                if(result) {
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
                    if (result.supplier == 0) {
                        $("#Supplier_Name").val("None")
                    } else{
                        $("#Supplier_Name").val(result.supplier)
                }
                    var material = result.item;
                    ajaxgetSupplierId(material);

                    // DO GET
                    function ajaxgetSupplierId(id){
                        $.ajax({
                            type : "GET",
                            url : "/sitemanager/supplier",
                            success: function(result){
                                if(result) {
                                    var supplierId = [];
                                    result.forEach(function (supplier) {
                                        if (supplier["material"] == id) {
                                            supplierId.push(supplier["supplier"])
                                        }
                                    });
                                    console.log("Success: ", supplierId);

                                    console.log(result.supplier);
                                    var select = document.getElementById("Supplier_Name");
                                    for (var i = 0; i <supplierId.length ; i++) {
                                        var option = document.createElement('option');
                                        option.text = option.value = supplierId[i];
                                        select.add(option, 1);

                                    }
                                }
                            },
                            error : function(e) {
                                $("#Supplier_Name").val("User not found");
                                console.log("ERROR: ", e);
                            }
                        });
                    }

                    var status = result.status;

                        if (status == 'Cancelled') {
                            $('#note').show();
                            $('#noteLabel').show();
                        } else if(status == 'Rejected') {
                            $('#note').show();
                            $('#noteLabel').show();
                        } else {
                            $('#note').hide();
                            $('#noteLabel').hide();
                        }



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
