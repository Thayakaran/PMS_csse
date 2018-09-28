$(document).ready(function () {

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

                        localStorage.setItem('email', result["email"]);
                        localStorage.setItem('role', result["role"]);

                        location.href = "home";

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
