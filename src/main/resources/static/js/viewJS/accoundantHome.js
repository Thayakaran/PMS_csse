$(document).ready(function () {

    var userRole = localStorage.getItem('role');

    if (userRole == null || userRole != "Account Staff") {

        location.href = "/";

        return;

    }

    $("#userwelcome").html(localStorage.getItem("userName"));

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
