$(document).ready(function () {

    var userRole = localStorage.getItem('role');

    if (userRole != null) {

        if (userRole == "Contractor") {

            location.href = "contractorHome.html";

        } else if (userRole == "Site Manager") {

            location.href = "sitemanagerHome.html";

        } else if (userRole == "Supplier") {

            location.href = "supplierHome.html";

        } else if (userRole == "Account Staff") {

            location.href = "accoundantHome.html";

        } else if (userRole == "Manager") {

            location.href = "managementHome";

        } else {

            location.href = "home.html";

        }

        return;

    }

    $("#forgotLink").click(function (e) {

        e.preventDefault();

        $.ajax({
            type : "PUT",
            contentType : "application/json",
            url : "/login/forgot/" + $("#email").val(),
            success: function (data, textStatus, xhr) {

                swal({title: "Success", text: data, type: "success"});

            },
            error: function (data, textStatus, xhr) {

                swal({title: "Error", text: data.responseText, type: "error"});

            }

        });

    });


    $("#login").click(function (event) {
        event.preventDefault();

        var credentials = {};

        credentials.email = $("#email").val();
        credentials.password = $("#password").val();

        if (credentials.email.trim() == "" || credentials.password == "") {

                swal({title: "Error", text: " Email and Password are Required!", type: "error"});

            return;
        }

        $.ajax({
            type : "GET",
            url : "/login/"+credentials.email,
            success: function(result){
                if(result){
                    if (result["password"] == credentials["password"]) {

                        localStorage.setItem('role', result["role"]);

                        if (result["role"] == "Contractor") {

                            location.href = "contractorHome.html";

                        } else if (result["role"] == "Site Manager") {

                            localStorage.setItem('email', credentials.email);
                            location.href = "sitemanagerHome.html";

                        } else if (result["role"] == "Supplier") {

                            location.href = "supplierHome.html";

                        } else if (result["role"] == "Account Staff") {

                            localStorage.setItem('userName', result["fName"]);
                            localStorage.setItem('email', credentials["email"]);
                            location.href = "accoundantHome.html";

                        } else if (result["role"] == "Manager") {

                            localStorage.setItem('userName', result["fName"]);
                            location.href = "managementHome";

                        } else {

                            location.href = "home.html";

                        }

                    } else {

                        swal({title: "Invalid Credentials", text: "Check your email and password!", type: "error"});

                    }

                } else{

                    swal({title: "Invalid Credentials", text: "Check your email and password!", type: "error"});
                }
            },
            error : function(e) {

                swal({title: "Error", text: "Unable to login to the system, Try again later!!", type: "error"});

            }
        });


    });

});
