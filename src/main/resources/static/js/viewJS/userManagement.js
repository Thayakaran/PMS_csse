
$('#email').keyup(function () {
    $('#password').val($(this).val()+"@pms");
});

$( document ).ready(function() {

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
            url : "users", //window.location +"users",
            data : JSON.stringify(formData),
            dataType : 'json',
            success : function(res) {
                if (res.error){
                    swal({title:"Error", text:res.error, type:"error"});
                }
                else{
                    swal({title:"Success", text:"Your Account Has Been Created. Please Login", type:"success"});
                    resetAddData();
                }
                // swal({title:"Success", text:"Your Account Has Been Created. Please Login", type:"success"});
                // resetData();
            }
            // error : function(e) {
            //     swal({title:"Error", text:"Error"+e, type:"error"});
            // }
        });

        // Reset FormData after Posting
        // resetData();

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
                    $("#searchTxt").val("User not found");
                    console.log("Fail: ", result);
                }
            },
            error : function(e) {
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
            url : "users", //window.location +"users",
            data : JSON.stringify(formData),
            dataType : 'json',
            success : function(res) {
                if (res.error){
                    swal({title:"Error", text:res.error, type:"error"});
                }
                else{
                    swal({title:"Success", text:"Your Account Has Been Created. Please Login", type:"success"});
                    resetUpdateData();
                }
                // swal({title:"Success", text:"Your Account Has Been Created. Please Login", type:"success"});
                // resetData();
            }
            // error : function(e) {
            //     swal({title:"Error", text:"Error"+e, type:"error"});
            // }
        });

        // Reset FormData after Posting
        // resetData();

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
            url : "users/"+id,
            success: function(result){
                if(result){
                    resetDeleteData();
                    console.log("Success: ", result);
                }else{
                    console.log("Fail: ", result);
                }
            },
            error : function(e) {
                console.log("ERROR: ", e);
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
