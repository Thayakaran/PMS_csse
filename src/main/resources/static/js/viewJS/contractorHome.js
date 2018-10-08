$(document).ready(function(){

    var userRole = localStorage.getItem('role');
    if (userRole == null || userRole != "Contractor") {
        //location.href = "/";
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
		let id = localStorage.getItem('id');
		$.ajax({
		  type: "GET",
		  url: "/orders/"+id+"/0/0/pending/0/0",
		  success: function(result) {
			  $('#pendingRequestsDT').DataTable({
				  "data" : result,
				  "columns" : [
					  { "data" : "managerName" },
					  { "data" : "item" },
					  { "data" : "quantity" },
					  { "data" : "location" },
					  { "data" : "status" },
					  { "defaultContent" : "<input type='submit' />" }

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
	getAllData();
});




