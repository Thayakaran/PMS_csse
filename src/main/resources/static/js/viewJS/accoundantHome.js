$(document).ready(function () {

    $('#payments-tab').click(function () {

        loadPaymentsPage();

    });

    $('#payments-tab').click();


    $("#logout").click(function () {
        localStorage.clear();
        location.href = "/";
    });

});


function loadProcessPaymentPage() {
    $('#payment-page').load('/pay');
    $("#payments-tab").removeClass("active");
}

function loadPaymentsPage() {
    $('#payment-page').load('/payments');
    $("#payments-tab").addClass("active");
}
