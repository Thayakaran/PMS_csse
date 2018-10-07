$(document).ready(function() {
    var pageURL = $(location).attr("href");

    if(pageURL == "http://localhost:3000/manageRequest.html") {

        location.href = "sitemanagerHome.html";

        return;

    }

    document.getElementById('Supplier_Name').disabled = true;


    var id = localStorage.getItem('id');

    $("#Request_id").val(id);
    ajaxGetRequestId(id);

    $('#note').hide();
    $('#noteLabel').hide();
    $('#price').hide();
    $('#SiteManagerId').hide();
    $('#SiteId').hide();
    $('#SupplierMail').hide();
    $('#SupplierId').hide();
    $('#OrderById').hide();
    $('#OrderByMail').hide();
    $('#OldSupplier').hide();


    $('#order_status').change(function() {
        var status =$('#order_status').val();
        if (status == 'Cancelled') {
            $('#note').show();
            $('#noteLabel').show();
            $('#OldSupplier').hide();
            document.getElementById('Supplier_Name').disabled = true;
        } else if (status == 'rejectedByManager') {
            $('#note').show();
            $('#noteLabel').show();
            $('#OldSupplier').hide();
            document.getElementById('Supplier_Name').disabled = true;
        } else if (status == 'approvedByManager') {
            $('#note').hide();
            $('#noteLabel').hide();
            $('#OldSupplier').hide();
            document.getElementById('Supplier_Name').disabled = false;
        } else if (status == 'rejectedBySupplier') {
            $('#note').hide();
            $('#noteLabel').hide();
            $('#OldSupplier').hide();
            document.getElementById('Supplier_Name').disabled = false;
        } else {
            $('#note').hide();
            $('#noteLabel').hide();
            $('#OldSupplier').hide();
            document.getElementById('Supplier_Name').disabled = true;
        }


    });
    $('#back').click(function () {
        location.href = "sitemanagerHome.html";
    });



    // DO GET
    function ajaxGetRequestId(id){
        $.ajax({
            type: "GET",
            url: "/sitemanager/" + id,
            success: function (result) {
                if (result) {
                    ajaxgetManagerName(result.manager);
                    $('#SiteManagerId').val(result.manager);
                    $("#SiteId").val(result.site),
                        ajaxgetSiteDetails(result.site);
                    $("#Order_date").val(result.date),
                        $("#require_date").val(result.requiredate),
                        $("#item").val(result.item),
                        $("#qty").val(result.qty),
                        $("#description").val(result.description),
                        $("#contact").val(result.contactnum),
                        $("#order_status").val(result.status),
                        $("#note").val(result.note)
                    ajaxgetOrderbyName(result.orderby);
                    $('#OrderById').val(result.orderby);
                    var status = result.status;

                    if (status == 'Cancelled') {
                        $('#note').show();
                        $('#noteLabel').show();
                        document.getElementById('Supplier_Name').disabled = true;
                    } else if (status == 'rejectedByManager') {
                        $('#note').show();
                        $('#noteLabel').show();
                        document.getElementById('Supplier_Name').disabled = true;
                    } else if (status == 'approvedByManager') {
                        $('#note').hide();
                        $('#noteLabel').hide();
                        document.getElementById('Supplier_Name').disabled = false;
                    } else if (status == 'rejectedBySupplier') {

                        ajaxgetSupplierName(result.supplier)
                        $('#note').hide();
                        $('#noteLabel').hide();
                        document.getElementById('Supplier_Name').disabled = false;
                    } else {
                        $('#note').hide();
                        $('#noteLabel').hide();
                        document.getElementById('Supplier_Name').disabled = true;
                    }


                    var material = result.item;
                    ajaxgetSupplierId(material);

                    // DO GET
                    function ajaxgetSupplierId(id) {
                        $.ajax({
                            type: "GET",
                            url: "/sitemanager/supplier",
                            success: function (result) {
                                if (result) {
                                    var supplierId = [];
                                    result.forEach(function (supplier) {
                                        if (supplier["material"] == id) {
                                            supplierId.push(supplier["supplierName"])
                                        }
                                    });
                                    console.log("Success: ", supplierId);

                                    console.log(result.supplier);
                                    var select = document.getElementById("Supplier_Name");
                                    for (var i = 0; i < supplierId.length; i++) {
                                        var option = document.createElement('option');
                                        option.text = option.value = supplierId[i];
                                        select.add(option, 1);

                                    }
                                }
                            },
                            error: function (e) {
                                $("#Supplier_Name").val("User not found");
                                console.log("ERROR: ", e);
                            }
                        });
                    }


                    console.log("Success: ", result);
                }
            else
                {
                    $("#Request_id").val("Request not found");
                    console.log("Fail: ", result);
                }
            },
            error: function (e) {
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
       var status =  $("#order_status").val();
        var formData ;

        if(status == 'approvedByManager')
        {
            formData = {
                supplier: $("#SupplierId").val(),
                status: $("#order_status").val(),
                note: $("#note").val(),
                personMail:$('#SupplierMail').val(),
                userName:$('#Supplier_Name').val(),
                infor:"I am " + $('#manager_name').val() +" i am manager of this " + $('#site_name').val() + " site. I am approved below material request id. Could you pleae send before " + $("#require_date").val() + " requested materials " ,
                id:$("#Request_id").val(),


            }

        }
        if(status == 'rejectedByManager')
        {
            formData = {
                supplier: $("#SupplierId").val(),
                status: $("#order_status").val(),
                note: $("#note").val(),
                personMail:$('#OrderByMail').val(),
                userName:$('#Requester_id').val(),
                infor:"I am " + $('#manager_name').val() +" i am manager of this " + $('#site_name').val() + " site. I am rejected below material request id. i am feel those material not required for now. if you have any issue about this please contact me." ,
                id:$("#Request_id").val(),
                requiredate:$("#require_date").val()


            }
        }


        // DO PUT
        $.ajax({
            type: "PUT",
            contentType: "application/json; charset=utf-8",
            url: "/sitemanager/" + id, //window.location +"users",
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function (result) {
                if (result.success){
                    swal({title:"Success", text:"Material Requested Successfully", type:"success"});
                }
                else{
                    swal({title:"Error", text:"Error occurred in updating User data", type:"error"});
                }

            },
            error : function(e) {
                swal({title:"Success", text:"Material Requested Successfully", type:"success"});
                location.href = "sitemanagerHome.html";
            }
        });
    }




    //get OrderBy user name by using user id
    function ajaxgetOrderbyName(id){
        $.ajax({
            type : "GET",
            url : "/sitemanager/mail/" + id,
            success: function(result){
                if(result) {
                    $("#Requester_id").val(result.managerName);
                    $("#OrderByMail").val(result.personMail);
                    }
                },
            error : function(e) {
                $("#Supplier_Name").val("User not found");
                console.log("ERROR: ", e);
            }
        });
    }


    //get Manager user name by using user id
    function ajaxgetManagerName(id){
        $.ajax({
            type : "GET",
            url : "/sitemanager/mail/" + id,
            success: function(result){
                if(result) {
                    $("#manager_name").val(result.managerName);
                }
            },
            error : function(e) {
                $("#Supplier_Name").val("User not found");
                console.log("ERROR: ", e);
            }
        });
    }

    //get Supplier user name by using user id
    function ajaxgetSupplierName(id){
        $.ajax({
            type : "GET",
            url : "/sitemanager/mail/" + id,
            success: function(result){
                if(result) {
                    $('#OldSupplier').html("Reject by " + result.managerName + " supplier");
                    $('#OldSupplier').show();
                }
            },
            error : function(e) {
                $("#Supplier_Name").val("User not found");
                console.log("ERROR: ", e);
            }
        });
    }

    //get site details
    function ajaxgetSiteDetails(id){
        $.ajax({
            type : "GET",
            url : "/sitemanager/site",
            success: function(result){
                if(result) {

                    result.forEach(function (supplier) {
                        if (supplier["site"] == id) {
                            $("#site_name").val(supplier["siteName"]);
                        }
                    });



                }
            },
            error : function(e) {
                $("#site_name").val("User not found");
                console.log("ERROR: ", e);
            }
        });
    }



});
