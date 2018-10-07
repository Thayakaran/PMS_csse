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

        var email;

        if ($("#email").val().trim() == "") {

            email = "null";

        } else {

            email = $("#email").val().trim();

        }

        $.ajax({
            type : "PUT",
            contentType : "application/json",
            url : "/login/forgot/" + email,
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
            url : "/login/"+credentials.email + "/" + credentials.password,
            success: function(data, textStatus, xhr){
                console.log(data.responseText);

                if (xhr.status == 200) {

                    localStorage.setItem('role', data["role"]);
                    localStorage.setItem('id', data["id"]);
                    localStorage.setItem('userName', data["fName"]);

                    if (data["role"] == "Contractor") {

                        location.href = "contractorHome.html";

                    } else if (data["role"] == "Site Manager") {

                        localStorage.setItem('email', credentials.email);
                        location.href = "sitemanagerHome.html";

                    } else if (data["role"] == "Supplier") {

                        location.href = "supplierHome.html";

                    } else if (data["role"] == "Account Staff") {

                        localStorage.setItem('email', credentials["email"]);
                        location.href = "accoundantHome.html";

                    } else if (data["role"] == "Manager") {

                        location.href = "managementHome";

                    } else {

                        location.href = "home.html";

                    }


                } else {

                    swal({title: "Invalid Credentials", text: data.responseText, type: "error"});

                }
            },
            error : function(data, textStatus, xhr) {

                swal({title: "Error", text: data.responseText, type: "error"});

            }
        });


    });

});
