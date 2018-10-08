

$(document).ready(function(){

    var userRole = localStorage.getItem('role');
    if (userRole == null || userRole != "Supplier") {
        location.href = "/";
    }

       $("#userwelcome").html(localStorage.getItem("userName"));

         $("#logout").click(function () {
               localStorage.clear();
               location.href = "/";
           });


         var username = localStorage.getItem('name');
           document.getElementById("userwelcome").innerHTML = username;
           document.getElementById("username").innerHTML = username;


///getting  supplier materials
  getAllData();

  function getAllData() {
    console.log("Get Data");

    $.ajax({
      type: "GET",
      url: "/supplierMeterial",
      success: function(result) {

          $('#supplierHome').DataTable({
              "data" : result,
              "columns" : [
                  { "data" : "supplierMaterialType" },
                  { "data" : "measurement" },
                  { "data" : "unitPrice" },

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

}function loadInvoicePage() {
     $('#invoice-page').load('/invoice.html');
     //$("#payments-tab").removeClass("active");
 }




           //register invoice
           $('#invoiceSubmitBtn').click(function () {
               $("#body").load('/invoice.html', function() {
                   $.getScript('/js/viewJS/invoice.js');
               });
           });

              //register supplier material
               $('#supplierMaterial').click(function () {
                   $("#body").load('/supplierMeterial.html', function() {
                       $.getScript('/js/viewJS/supplierMaterial.js');
                   });
               });








});




