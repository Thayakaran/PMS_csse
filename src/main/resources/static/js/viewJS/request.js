$('#email').keyup(function () {
    $('#password').val($(this).val()+"@pms");
});

$( document ).ready(function() {

    var pageURL = $(location).attr("href");

    if(pageURL == "http://localhost:3000/request.html") {

        location.href = "sitemanagerHome.html";

        return;

    }



    var useremail = localStorage.getItem('email');
    ajaxGetRequester(useremail);

    function ajaxGetRequester(useremail) {
    $.ajax({
            type : "GET",
            url : "/sitemanager/manager/" + useremail,
            success: function(result){
                if(result) {

                    $("#Requester_id").val(result.managerName),
                        $("#manager_name").val(result.managerName),
                        $("#contact").val(result.contactnum),
                        $("#SiteManagerId").val(result.userId),

                        ajaxgetSiteDetails();


                    console.log("Success: ", result);

                }
            },
            error : function(e) {
                $("#Supplier_Name").val("User not found");
                console.log("ERROR: ", e);
            }
        });

    }

    //get site details
    function ajaxgetSiteDetails(){
        $.ajax({
            type : "GET",
            url : "/sitemanager/site",
            success: function(result){
                if(result) {
                    var supplierName = [];
                    result.forEach(function (supplier) {
                        if (supplier["id"] == $("#SiteManagerId").val()) {
                            supplierName.push(supplier["siteName"])
                        }
                    });
                    console.log("Success: ", supplierName);

                    console.log(result.supplier);
                    var select = document.getElementById("site_name");
                    for (var i = 0; i <supplierName.length ; i++) {
                        var option = document.createElement('option');
                        option.text = option.value = supplierName[i];
                        select.add(option, 1);

                    }
                }
            },
            error : function(e) {
                $("#site_name").val("User not found");
                console.log("ERROR: ", e);
            }
        });
    }





    $('#back').click(function () {
        location.href = "sitemanagerHome.html";
    });


    $('#note').hide();
    $('#noteLabel').hide();
    $('#price').hide();
    $('#SiteManagerId').hide();
    $('#SiteId').hide();
    $('#SupplierMail').hide();
    $('#SupplierId').hide();
    $('#SupplierId').val("approvedByManager");



    $('#order_status').change(function() {
        if (this.value == 'Cancelled') {
            $('#note').show();
            $('#noteLabel').show();
        } else if(this.value == 'rejectedByManager') {
            $('#note').show();
            $('#noteLabel').show();
        } else if(this.value == 'rejectedBySupplier') {
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
            orderby: $("#SiteManagerId").val(),
            site: $("#SiteId").val(),
            manager: $("#SiteManagerId").val(),
            date: $("#Order_date").val(),
            requiredate: $("#require_date").val(),
            item: $("#item").val(),
            qty: $("#qty").val(),
            description: $("#description").val(),
            contactnum: $("#contact").val(),
            supplier: $("#SupplierId").val(),
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
            success: function (result) {
                if (result.success){
                    swal({title:"Success", text:"Material Requested Successfully", type:"success"});
                }
                else{
                    swal({title:"Error", text:"Error occurred in adding User, Enter valid Data", type:"error"});
                }
            },
            error : function(e) {
                swal({title:"Success", text:"Material Requested Successfully", type:"success"});
                location.href = "sitemanagerHome.html";
            }
        });

    }
});

