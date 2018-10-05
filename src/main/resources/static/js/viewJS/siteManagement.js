$( document ).ready(function() {

    //navigate to userManagement
    $('.userMng').click(function () {
        localStorage.setItem('nav', "addUser");
        document.location.href = "/home.html";
        // $("#body").load('/userManagement.html', function() {
        //     $.getScript('/js/viewJS/userManagement.js');
        // });
    });

    /////////////////////////////////////////////////////////////////////////////////
    //ajax calls to fill the options from database

    $.ajax({
        type : "GET",
        url : "users/role/Site Manager",
        success: function(result){
            if(result){
                for(var i = 0; i<result.length; i++){
                    var option = $('<option></option>').attr("value", result[i].fName+" "+result[i].lName).text(result[i].fName+" "+result[i].lName);
                    $("#siteManager,#UsiteManager").append(option);
                }
            }else{
                console.log("Fail: ", result);
            }},
        error : function(e) {
            console.log("ERROR: ", e);
        }
    });

    $.ajax({
        type : "GET",
        url : "users/role/Contractor",
        success: function(result){
            if(result){
                for(var i = 0; i<result.length; i++){
                    var option = $('<option></option>').attr("value", result[i].fName+" "+result[i].lName).text(result[i].fName+" "+result[i].lName);
                    $("#contractors,#Ucontractors").append(option);
                }
            }else{
                console.log("Fail: ", result);
            }},
        error : function(e) {
            console.log("ERROR: ", e);
        }
    });

    $.ajax({
        type : "GET",
        url : "users/role/Supplier",
        success: function(result){
            if(result){
                for(var i = 0; i<result.length; i++){
                    var option = $('<option></option>').attr("value", result[i].fName+" "+result[i].lName).text(result[i].fName+" "+result[i].lName);
                    $("#suppliers,#Usuppliers").append(option);
                }
            }else{
                console.log("Fail: ", result);
            }},
        error : function(e) {
            console.log("ERROR: ", e);
        }
    });

    /////////////////////////////////////////////////////////////

    // ADD NEW SITE
    $("#addNewSiteForm").submit(function(event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();
        ajaxPostNewSite();
    });

    function ajaxPostNewSite(){

        // PREPARE FORM DATA
        var formData = {
            siteID : $("#siteId").val(),
            location :  $("#siteLocation").val(),
            client : $("#siteClient").val(),
            manager :  $("#siteManager").val(),
            contractors : $("#contractors").val().toString(),
            suppliers :  $("#suppliers").val().toString()

        }

        // DO POST
        $.ajax({
            type : "POST",
            contentType : "application/json; charset=utf-8",
            url : "sites", //window.location +"users",
            data : JSON.stringify(formData),
            dataType : 'json',
            success : function(result) {
                if (result.success){
                    swal({title:"Success", text:"New Site has been added", type:"success"});
                    resetAddData();
                }
                else{
                    swal({title:"Error", text:"Error occurred in adding data, Enter unique Site ID", type:"error"});
                }
            },
            error : function(e) {
                swal({title:"Error", text:"Error occurred in adding data, Enter unique Site ID", type:"error"});
            }
        });

    }

    function resetAddData(){
        $("#siteId").val(""),
        $("#siteLocation").val(""),
        $("#siteClient").val(""),
        $("#siteManager").val(""),
        $("#contractors").val(""),
        $("#suppliers").val("")
    }

    //////////////////////////////////////////////////////////////////////////////////


    // GET Site BY ID(search to update)
    $("#searchBtn").click(function(event){
        event.preventDefault();
        var id = $("#searchTxt").val();

        ajaxGetSiteById(id);
    });

    // DO GET
    function ajaxGetSiteById(id){
        $.ajax({
            type : "GET",
            url : "sites/"+id,
            success: function(result){
                if(result){

                    $("#UsiteId").val(result.siteID),
                    $("#UsiteLocation").val(result.location),
                    $("#UsiteClient").val(result.client),
                    $("#UsiteManager").val(result.manager),
                    $("#Ucontractors").val(result.contractors.split(",")),
                    $("#Usuppliers").val(result.suppliers.split(","))

                }else{
                    document.getElementById("searchTxt").style.color = "red";
                    $("#searchTxt").val("Site not found");
                    console.log("Fail: ", result);
                }
            },
            error : function(e) {
                document.getElementById("searchTxt").style.color = "red";
                $("#searchTxt").val("Site not found");

                console.log("ERROR: ", e);
            }
        });
    }

    /////////////////////////////////////////////////////////////

    // UPDATE EXISTING SITE
    $("#updateSiteForm").submit(function(event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();
        ajaxPostUpdateSite();
    });

    function ajaxPostUpdateSite(){

        // PREPARE FORM DATA
        var formData = {
            siteID : $("#UsiteId").val(),
            location :  $("#UsiteLocation").val(),
            client : $("#UsiteClient").val(),
            manager :  $("#UsiteManager").val(),
            contractors : $("#Ucontractors").val().toString(),
            suppliers :  $("#Usuppliers").val().toString()

        }

        // DO PUT
        $.ajax({
            type : "PUT",
            contentType : "application/json; charset=utf-8",
            url : "sites",
            data : JSON.stringify(formData),
            dataType : 'json',
            success : function(result) {
                if (result.success){
                    swal({title:"Success", text:"Site has been updated", type:"success"});
                    resetUpdateData();
                }
                else{
                    swal({title:"Error", text:"Error occurred in updating data", type:"error"});
                }
            },
            error : function(e) {
                swal({title:"Error", text:"Error occurred in updating data", type:"error"});
            }
        });

    }

    function resetUpdateData(){
        $("#UsiteId").val(""),
        $("#UsiteLocation").val(""),
        $("#UsiteClient").val(""),
        $("#UsiteManager").val(""),
        $("#Ucontractors").val(""),
        $("#Usuppliers").val("")
    }

    // ///////////////////////////////////////////////////////////////////////////

    // DELETE SITE BY ID
    $("#deleteSite").click(function(event){
        event.preventDefault();
        var id = $("#UsiteId").val();

        ajaxDeleteSiteById(id);
    });

    // DO DELETE
    function ajaxDeleteSiteById(id){
        $.ajax({
            type : "DELETE",
            contentType : "application/json; charset=utf-8",
            url : "sites/"+id,
            dataType : 'json',
            success: function(result){
                if (result.success){
                    swal({title:"Success", text:"Site Deleted Successfully", type:"success"});
                    resetDeleteData();
                }
                else{
                    swal({title:"Error", text:"Error occurred in Deleting Site", type:"error"});
                }
            },
            error : function(e) {
                swal({title:"Error", text:"Error occurred in Deleting Site", type:"error"});
            }
        });
    }

    function resetDeleteData(){
        $("#UsiteId").val(""),
        $("#UsiteLocation").val(""),
        $("#UsiteClient").val(""),
        $("#UsiteManager").val(""),
        $("#Ucontractors").val(""),
        $("#Usuppliers").val("")
    }

});
