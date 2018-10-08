$(document).ready(function() {

    var pageURL = $(location).attr("href");

    if(pageURL == "http://localhost:3000/orderDetails") {

        location.href = "orderDetails.html";

        return;

    }

    var userRole = localStorage.getItem('role');



  getAllData();

//getting all orders which are approved by site manager

  function getAllData() {
    console.log("Get Data");

    $.ajax({
      type: "GET",
      url: "/orders/0/0/59/approvedByManager/0/0",
      success: function(result) {

          $('#datatable-responsive-orderDetail').DataTable({
              "data" : result,
              "columns" : [
                    { "data" : "id" },
                  { "data" : "site" },
                  { "data" : "contactNo" },
                  { "data" : "date" },
                  { "data" : "requiredDate" },
                  { "data" : "description" },
                  { "data" : "quantity" },
                  { "data" : "status" },
                  {"defaultContent" : "<button id='btnedit' class='btn btn-success' > edit </button>"},
                  {"defaultContent" : "<button id='btnInvoice' class='btn btn-success' > Invoice </button>"},

                  {"defaultContent" : "<button id='btnReceipt' class='btn btn-success' > Receipt </button>"}
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



/// invoice button click event
      $('#datatable-responsive-orderDetail').on('click', '#btnInvoice', function () {


          var table = $('#datatable-responsive-orderDetail').DataTable();

          var data = table.row($(this).closest('td, li')).data();

          alert(data);

          localStorage.removeItem("id");
          localStorage.removeItem("description");
          localStorage.removeItem("quantity");

          localStorage.setItem('orderId', data["id"]);
          localStorage.setItem('description', data["description"]);
          localStorage.setItem('qty', data["quantity"]);

          window.location.replace("http://localhost:3000/invoice.html");


      });

      // edit button onclick event

       $('#datatable-responsive-orderDetail').on('click', '#btnedit', function () {


                var table = $('#datatable-responsive-orderDetail').DataTable();

                var data = table.row($(this).closest('td, li')).data();



                localStorage.removeItem("id");
                localStorage.removeItem("status");


                localStorage.setItem('id', data["id"]);
                localStorage.setItem('status', data["status"]);


                window.location.replace("http://localhost:3000/editStatus.html");


            });

  }



});


