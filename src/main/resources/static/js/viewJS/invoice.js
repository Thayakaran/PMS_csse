

$( document ).ready(function() {

    // ADD NEW INVOICE
    $("#invoiceForm").click(function(event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();
        ajaxPostNewInvoice();
    });

    function ajaxPostNewInvoice(){

        // PREPARE FORM DATA
        var formData = {
            orderID : $("#orderId").val(),
            totalAmount :  $("#totalAmount").val(),
            discount : $("#discount").val(),
            netAmount :  $("#netAmount").val(),
        }

        // DO POST
        $.ajax({
            type : "POST",
            contentType : "application/json; charset=utf-8",
            url : "invoices", //window.location +"invoice",
            data : JSON.stringify(formData),
            dataType : 'json',
            success : function(res) {
                if (res.error){
                    swal({title:"Error", text:res.error, type:"error"});
                }
                else{
                    swal({title:"Success", text:"Invoice Inserted.", type:"success"});
                    resetData();
                }
                // swal({title:"Success", text:"Your Account Has Been Created. Please Login", type:"success"});
                // resetData();
            }
            // error : function(e) {
            //     swal({title:"Error", text:"Error"+e, type:"error"});
            // }
        });

        // Reset FormData after Posting
        // resetData();

    }

    function resetData(){
        $("#orderId").val("");
        $("#totalAmount").val("");
        $("#discount").val("");
        $("#netAmount").val("");

    }

    /////////////////////////////////////////////////////////////////////////////////

     // GET USER BY ID(search)
        $("#searchBtn").click(function(event){
            event.preventDefault();
            var id = $("#searchTxt").val();

            ajaxGetUserById(id);
        });

        // DO GET
        function ajaxGetUserById(id){
            $.ajax({
                type : "GET",
                url : "invoices/"+id,
                success: function(result){
                    if(result){
                        $("#UfName").val(result.fName),
                        $("#UlName").val(result.lName),
                        $("#UmPhone").val(result.mPhone),
                        $("#UoPhone").val(result.oPhone),
                        $("#UhAddress").val(result.hAddress),
                        $("#UwAddress").val(result.wAddress),
                        $("#Urole").val(result.role),
                        $("#Uemail").val(result.email),
                        $("#Upassword").val(result.password)

                    console.log("Success: ", result);
                    }else{
                        document.getElementById("searchTxt").style.color = "red";
                        $("#searchTxt").val("Invoice not found");
                        console.log("Fail: ", result);
                    }
                },
                error : function(e) {
                    document.getElementById("searchTxt").style.color = "red";
                    $("#searchTxt").val("Invoice not found");
                    console.log("ERROR: ", e);
                }
            });
        }



    ///////////////////////////////////////////////////////////////////////////

    // DELETE USER BY ID
    $("#searchBtn").click(function(event){
        event.preventDefault();
        var id = $("#searchTxt").val();

        ajaxDeleteInvoiceById(id);
    });

    // DO DELETE
    function ajaxDeleteInvoiceById(id){
        $.ajax({
            type : "DELETE",
            url : "invoice/"+id,
            success: function(result){
                if(result){

                    console.log("Success: ", result);
                }else{
                    console.log("Fail: ", result);
                }
            },
            error : function(e) {
                console.log("ERROR: ", e);
            }
        });
    }

})
