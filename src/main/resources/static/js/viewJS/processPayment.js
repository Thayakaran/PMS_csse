$(document).ready(function () {

    var pageURL = $(location).attr("href");

    if(pageURL == "http://localhost:3000/pay") {

        location.href = "accoundantHome.html";

        return;

    }

    var invoiceID = localStorage.getItem("invoiceID");

    var userRole = localStorage.getItem('role');

    if (userRole == null || userRole != "Account Staff") {

        location.href = "/";

        return;

    }

    if (invoiceID == null && userRole == "Account Staff") {

        location.href = "accoundantHome.html";

        return;

    }

    $('#invoiceID').val(invoiceID);
    $('#amount').val(localStorage.getItem("amount"));

    localStorage.removeItem("invoiceID");
    localStorage.removeItem("amount");

    $("#paidButton").click(function () {

        updatePaymentStatus();

    });

    $("#payButton").click(function (e) {

        e.preventDefault();

        var form = $("#paymentForm");

        if (form.valid()) {

            event.preventDefault();

            var paymentDetails = {
                cardholerName: $("#cardholerName").val(),
                cardNo: $("#cardNo").val(),
                expDate: $("#expDate").val(),
                cvv: $("#cvv").val(),
                amount: $("#amount").val()
            }

            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "/pay",
                data: JSON.stringify(paymentDetails),
                success: function (data, textStatus, xhr) {
                    updatePaymentStatus();
                },
                error: function (data, textStatus, xhr) {
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

    function updatePaymentStatus() {

        var date = new Date($.now());
        var strDate = {date: date.getFullYear()+"-"+date.getMonth()+"-"+date.getDay()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds()};

        $.ajax({
            type : "PUT",
            contentType : "application/json",
            url : "/invoices/updatePaymentStatus/" + invoiceID,
            data : JSON.stringify(strDate),
            success : function(res) {
                if (res.error){
                    swal({title:"Error", text: "Unable to set the payment status", type:"error"});
                }
                else{
                    swal({title:"Success", text:"Payment status successfully updated", type:"success"});
                    parent.loadPaymentsPage();
                }
            },
            error : function (error) {
                console.log("error" + error);
            }

        });

    }


});