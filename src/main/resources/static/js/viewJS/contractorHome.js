$(document).ready(function(){

    var userRole = localStorage.getItem('role');
    if (userRole == null || userRole != "Contractor") {
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


	function getAllData() {
		$.ajax({
		  type: "GET",
		  url: "/supplierMeterial",
		  success: function(result) {
			  $('#pendingRequestsDT').DataTable({
				  "data" : result,
				  "columns" : [
					  { "data" : "Manager" },
					  { "data" : "Item" },
					  { "data" : "quantity" },
					  { "data" : "siteLocation" },
					  { "data" : "status" }

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
});




