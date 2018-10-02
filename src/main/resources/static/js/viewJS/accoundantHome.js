$(document).ready(function () {

    $('#payments-tab').click(function () {

        $('#payment-page').load('/payments');

    });

    $('#payments-tab').click();


    $("#logout").click(function () {
        location.href = "/";
    });

});