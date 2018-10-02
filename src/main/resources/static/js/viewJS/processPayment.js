$(document).ready(function () {

    var invoiceID = localStorage.getItem("invoiceID");

    $('#invoiceID').val(invoiceID);
    $('#amount').val(localStorage.getItem("amount"));

    localStorage.clear();

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
                contentType: "application/json; charset=utf-8",
                url: "/pay",
                data: JSON.stringify(paymentDetails),
                dataType: 'json',
                success: function (res) {
                    if (res.error) {
                        swal({title: "Error", text: res.error, type: "error"});
                    }
                    else {
                        swal({title: "Success", text: "Payment Sent", type: "success"});
                        ('#resetButton').click();
                    }
                }
            });

        }

    });


});