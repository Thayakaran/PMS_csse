

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
                  { "data" : "supplierID" }

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




