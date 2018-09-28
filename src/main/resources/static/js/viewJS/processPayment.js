$(document).ready(function () {

    $("#paymentForm").submit(function(event) {
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


    });


});
