$(document).ready(function() {

    var pageURL = $(location).attr("href");

    if(pageURL == "http://localhost:3000/payments") {

        location.href = "accoundantHome.html";

        return;

    }

    var userRole = localStorage.getItem('role');

    if (userRole == null || userRole != "Account Staff") {

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

          $('#datatable-responsive_unpaid').DataTable({
              "data" : result,
              "columns" : [
                  { "data" : "invoiceID" },
                  { "data" : "paymentStatus" },
                  { "data" : "orderID" },
                  { "data" : "date" },
                  { "data" : "item" },
                  { "data" : "supplier" },
                  { "data" : "quantity" },
                  { "data" : "orderedBy" },
                  { "data" : "totalAmount" },
                  { "data" : "discount" },
                  { "data" : "netAmount" },
                  { "data" : "contactNo" },
                  {"defaultContent" : "<button id='btnDetails' class='btn btn-success' > Pay </button>"}
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


      $.ajax({
          type: "GET",
          url: "/invoices/paid",
          success: function(result) {

              $('#datatable-responsive_paid').DataTable({
                  "data" : result,
                  "columns" : [
                      { "data" : "invoiceID" },
                      { "data" : "paymentStatus" },
                      { "data" : "paidDate" },
                      { "data" : "orderID" },
                      { "data" : "date" },
                      { "data" : "item" },
                      { "data" : "supplier" },
                      { "data" : "quantity" },
                      { "data" : "orderedBy" },
                      { "data" : "totalAmount" },
                      { "data" : "discount" },
                      { "data" : "netAmount" },
                      { "data" : "contactNo" }
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
