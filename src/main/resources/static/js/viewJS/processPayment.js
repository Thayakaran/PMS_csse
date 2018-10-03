$(document).ready(function () {

    var invoiceID = localStorage.getItem("invoiceID");

    $('#invoiceID').val(invoiceID);
    $('#amount').val(localStorage.getItem("amount"));

    localStorage.clear();

    $("#paidButton").click(function () {

        $.ajax({
            type : "PUT",
            contentType : "application/json; charset=utf-8",
            url : "/invoices/updatePaymentStatus/" + invoiceID,
            success : function(res) {
                if (res.error){
                    swal({title:"Error", text: "Unable to set the payment status", type:"error"});
                }
                else{
                    swal({title:"Success", text:"Payment status successfully updated", type:"success"});
                    parent.loadPaymentsPage();
                }
            }
        });

    });

    $("#paymentForm").submit(function(event) {
        if(this.checkValidity())
        {
            event.preventDefault();

            var paymentDetails = {
                cardholerName : $("#cardholerName").val(),
                cardNo :  $("#cardNo").val(),
                expDate : $("#expDate").val(),
                cvv :  $("#cvv").val(),
                amount : $("#amount").val()
            }

            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "/pay",
                data: JSON.stringify(paymentDetails),
                success: function (data, textStatus, xhr) {
                    swal({title: "Success", text: data.responseText, type: "success"});
                    parent.loadPaymentsPage();

                },
                error : function(data, textStatus, xhr) {
                    swal({title: "Error", text: data.responseText, type: "error"});
                }
            });
        }

    });


    $("#reset").click(function (event) {

        event.preventDefault();

        $("#cardholerName").val("");
        $("#cardNo").val("");
        $("#expDate").val("");
        $("#cvv").val("");

    });


    $("#cancel").click(function (event) {

        event.preventDefault();

        parent.loadPaymentsPage();

    });


});