$(document).ready(function(){

	fillMaterials();
	fillManagers();
	fillSites();
	
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


	function fillMaterials() {
		$.ajax({
		  type: "GET",
		  url: "/orders/materials",
		  success: function(result) {
				for(let i=0; i<result.length; i++){
					$('#materials').append(
					$('<option />')
						.text(result[i])
						.val(result[i]),
					);
				}
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
	function fillManagers() {
		let id = localStorage.getItem('id');
		$.ajax({
		  type: "GET",
		  url: "/orders/managers",
		  success: function(result) {
				for(let i=0; i<result.length; i++){
					$('#sitemanager').append(
					$('<option />')
						.text(result[i].fName)
						.val(result[i].id),
					);
				}
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
	function fillSites() {
		let id = localStorage.getItem('id');
		$.ajax({
		  type: "GET",
		  url: "/orders/sites",
		  success: function(result) {
				for(let i=0; i<result.length; i++){
					$('#sites').append(
					$('<option />')
						.text(result[i].location)
						.val(result[i].siteID),
					);
				}
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
	$("#order").click(function (event) {
		let id = localStorage.getItem('id');
        event.preventDefault();
        var formdata = {};

        formdata.orderedBy= id;
        formdata.manager= $("#sitemanager").val();
        formdata.item= $("#materials").val();
        formdata.quantity= $("#quantity").val();
        formdata.requiredDate= $("#requiredDate").val();
        formdata.description= $("#description").val();
        formdata.site= $("#sites").val();
        formdata.contactNo= $("#contactNo").val();
        formdata.note= $("#note").val();
		
        $.ajax({
            url: '/orders/',
            contentType:"application/json; charset=utf-8",
            data:JSON.stringify(formdata),
            type:'POST',
            success:function (res) {
                console.log(res.error);
                if (res.success){
                    swal({title:"Success", text:"Your Order Has Been Submitted successfully.", type:"success"}).then(function () {
                        location.href = "home.html";
                    });;
                }
                if (res.error){
                    swal({title:"Error", text:res.error, type:"error"});
                }
            }
        });
    });
});




