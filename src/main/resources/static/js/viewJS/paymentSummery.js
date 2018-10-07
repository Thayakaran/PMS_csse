$(document).ready(function() {

    var pageURL = $(location).attr("href");

    if(pageURL == "http://localhost:3000/payments") {

        location.href = "accoundantHome.html";

        return;

    }

    var userRole = localStorage.getItem('role');

    if (userRole == null || userRole != "Supplier") {

        location.href = "/";

        return;

    }

  getAllData();

  function getAllData() {
    console.log("Get Data");

    $.ajax({
      type: "GET",
      url: "/invoices/unpaid",
      success: function(result) {

          $('#datatable-responsive-payment-summery').DataTable({
              "data" : result,
              "columns" : [
                  { "data" : "orderID" },
                  { "data" : "site" },
                  { "data" : "description" },
                  { "data" : "quantity" },
                  { "data" : "netAmount" },
                  { "data" : "paymentStatus" }


              ],
              "bDestroy": true
          });


      },
      error: function(e) {
        swal({
          title: "Error",
          text: "Unable to get data, Try again later!!",
          type: "error"
        });
      }
    });




      $('#datatable-responsive_unpaid').on('click', '#btnDetails', function () {
          var table = $('#datatable-responsive_unpaid').DataTable();2

          var data = table.row($(this).closest('td, li')).data();

          localStorage.removeItem("invoiceID");
          localStorage.removeItem("amount");

          localStorage.setItem('invoiceID', data["invoiceID"]);
          localStorage.setItem('amount', data["netAmount"]);

          parent.loadProcessPaymentPage();

      });

  }
});
