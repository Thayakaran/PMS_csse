var userRole = localStorage.getItem('role');
if (userRole == null || userRole != "Manager") {
    location.href = "/";
}

$('#email').keyup(function () {
    $('#password').val($(this).val()+"@pms");
});

$( document ).ready(function() {

    //Get all user data
    getAllSiteData();

    function getAllSiteData() {
        $.ajax({
            type: "GET",
            url: "/users",
            success: function (result) {

                $('#datatable-responsive_users').DataTable({
                    "data": result,
                    "columns": [
                        {"data": "id"},
                        {"data": "fName"},
                        {"data": "lName"},
                        {"data": "mPhone"},
                        {"data": "oPhone"},
                        {"data": "hAddress"},
                        {"data": "wAddress"},
                        {"data": "role"},
                        {"data": "email"}
                    ],
                    "bDestroy": true
                });

            },
            error: function (e) {
                swal({
                    title: "Error",
                    text: "Unable to load user data, May be a Network issue!",
                    type: "error"
                });
            }
        });
    }

    // ADD NEW USER
    $("#userRegisterForm").submit(function(event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();
        ajaxPostNewUser();
    });

    function ajaxPostNewUser(){

        // PREPARE FORM DATA
        var formData = {
            fName : $("#fName").val(),
            lName :  $("#lName").val(),
            mPhone : $("#mPhone").val(),
            oPhone :  $("#oPhone").val(),
            hAddress : $("#hAddress").val(),
            wAddress :  $("#wAddress").val(),
            role : $("#role").val(),
            email :  $("#email").val(),
            password :  $("#password").val()

        }

        // DO POST
        $.ajax({
            type : "POST",
            contentType : "application/json; charset=utf-8",
            url : "users",
            data : JSON.stringify(formData),
            dataType : 'json',
            success : function(result) {
                if (result.success){
                    swal({title:"Success", text:"New User added Successfully", type:"success"});
                    resetAddData();
                    getAllSiteData();
                }
                else{
                    swal({title:"Error", text:"Error occurred in adding User, Enter valid Data", type:"error"});
                }
            },
            error : function(e) {
                swal({title:"Error", text:"Error occurred in adding User, Enter valid Data", type:"error"});
            }
        });

    }

    function resetAddData(){
        $("#fName").val(""),
        $("#lName").val(""),
        $("#mPhone").val(""),
        $("#oPhone").val(""),
        $("#hAddress").val(""),
        $("#wAddress").val(""),
        $("#role").val(""),
        $("#email").val(""),
        $("#password").val("")
    }

    /////////////////////////////////////////////////////////////////////////////////

    // GET USER BY ID(search)
    $("#searchBtn").click(function(event){
        event.preventDefault();
        var id = $("#searchTxt").val();

        ajaxGetUserById(id);
    });

    // DO GET
    function ajaxGetUserById(id){
        $.ajax({
            type : "GET",
            url : "users/"+id,
            success: function(result){
                if(result){
                    $("#UfName").val(result.fName),
                    $("#UlName").val(result.lName),
                    $("#UmPhone").val(result.mPhone),
                    $("#UoPhone").val(result.oPhone),
                    $("#UhAddress").val(result.hAddress),
                    $("#UwAddress").val(result.wAddress),
                    $("#Urole").val(result.role),
                    $("#Uemail").val(result.email),
                    $("#Upassword").val(result.password)

                console.log("Success: ", result);
                }else{
                    document.getElementById("searchTxt").style.color = "red";
                    $("#searchTxt").val("User not found");
                    console.log("Fail: ", result);
                }
            },
            error : function(e) {
                document.getElementById("searchTxt").style.color = "red";
                $("#searchTxt").val("User not found");
                console.log("ERROR: ", e);
            }
        });
    }

    /////////////////////////////////////////////////////////////

    // UPDATE EXISTING USER
    $("#userUpdateForm").submit(function(event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();
        ajaxPostUpdateUser();
    });

    function ajaxPostUpdateUser(){

        // PREPARE FORM DATA
        var formData = {
            id : $("#searchTxt").val(),
            fName : $("#UfName").val(),
            lName :  $("#UlName").val(),
            mPhone : $("#UmPhone").val(),
            oPhone :  $("#UoPhone").val(),
            hAddress : $("#UhAddress").val(),
            wAddress :  $("#UwAddress").val(),
            role : $("#Urole").val(),
            email :  $("#Uemail").val(),
            password :  $("#Upassword").val()

        }

        // DO PUT
        $.ajax({
            type : "PUT",
            contentType : "application/json; charset=utf-8",
            url : "users",
            data : JSON.stringify(formData),
            dataType : 'json',
            success : function(result) {
                if (result.success){
                    swal({title:"Success", text:"User has been updated", type:"success"});
                    resetUpdateData();
                    getAllSiteData();

                }
                else{
                    swal({title:"Error", text:"Error occurred in updating User data", type:"error"});
                }
            },
            error : function(e) {
                swal({title:"Error", text:"Error occurred in updating User data", type:"error"});
            }
        });

    }

    function resetUpdateData(){
        $("#UfName").val(""),
        $("#UlName").val(""),
        $("#UmPhone").val(""),
        $("#UoPhone").val(""),
        $("#UhAddress").val(""),
        $("#UwAddress").val(""),
        $("#Urole").val(""),
        $("#Uemail").val(""),
        $("#Upassword").val("")
    }

    ///////////////////////////////////////////////////////////////////////////

    // DELETE USER BY ID
    $("#deleteUser").click(function(event){
        event.preventDefault();
        var id = $("#searchTxt").val();

        ajaxDeleteUserById(id);
    });

    // DO DELETE
    function ajaxDeleteUserById(id){
        $.ajax({
            type : "DELETE",
            contentType : "application/json; charset=utf-8",
            url : "users/"+id,
            dataType : 'json',
            success: function(result){
                if (result.success){
                    swal({title:"Success", text:"User Deleted Successfully", type:"success"});
                    resetDeleteData();
                    getAllSiteData();
                }
                else{
                    swal({title:"Error", text:"Error occurred in Deleting User", type:"error"});
                }
            },
            error : function(e) {
                swal({title:"Error", text:"Error occurred in Deleting User", type:"error"});
            }
        });
    }

    function resetDeleteData(){
            $("#UfName").val(""),
            $("#UlName").val(""),
            $("#UmPhone").val(""),
            $("#UoPhone").val(""),
            $("#UhAddress").val(""),
            $("#UwAddress").val(""),
            $("#Urole").val(""),
            $("#Uemail").val(""),
            $("#Upassword").val("")
    }

});


