$( document ).ready(function() {

    // SUBMIT FORM
    $("#userForm").submit(function(event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();
        ajaxPost();
    });


    function ajaxPost(){

        // PREPARE FORM DATA
        var formData = {
            name : $("#name").val(),
            address :  $("#address").val()
        }

        // DO POST
        $.ajax({
            type : "POST",
            contentType : "application/json; charset=utf-8",
            url : window.location +"users",
            data : JSON.stringify(formData),
            dataType : 'json',
            success : function(res) {
                if(!result.error){
                    $("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" +
                        "Post Successfully! <br>" +
                        "---> User's Info: Name = " +
                        result.data.name + " ,LastName = " + result.data.address + "</p>");
                }else{
                    $("#postResultDiv").html("<strong>Error</strong>");
                }
                console.log(res);
            },
            error : function(e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });

        // Reset FormData after Posting
        resetData();

    }

    function resetData(){
        $("#name").val("");
        $("#address").val("");
    }

    ///////////////////////////////////////

    // GET REQUEST
    $("#getAllUsers").click(function(event){
        event.preventDefault();
        ajaxGet();
    });

    // DO GET
    function ajaxGet(){
        $.ajax({
            type : "GET",
            url : window.location + "users",
            success: function(result){
                // if(result){
                $('#getResultDiv ul').empty();
                var userList = "";
                $.each(result.data, function(i, user){
                    userList = "- User with Id = " + i + ", Name = " + user.name + ", Address = " + user.address + "<br>";
                    $('#getResultDiv .list-group').append(userList)
                });
                console.log("Success: ", result);
                // }else{
                //     $("#getResultDiv").html("<strong>Error</strong>");
                //     console.log("Fail: ", result);
                // }
            },
            error : function(e) {
                $("#getResultDiv").html("<strong>Error</strong>");
                console.log("ERROR: ", e);
            }
        });
    }
})