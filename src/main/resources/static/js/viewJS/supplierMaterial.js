

$( document ).ready(function() {

    // ADD NEW USER
    $("#supplierMeterialForm").submit(function(event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();
        ajaxPostNewSupplierMaterial();
    });

    function ajaxPostNewSupplierMaterial(){

        // PREPARE FORM DATA
        var formData = {
            supplierMaterialType : $("#supplierMaterialType").val(),
            measurement:  $("#measurement").val(),
            unitPrice : $("#unitPrice").val(),
            supplierID :  $("#supplierID").val(),
         }

        // DO POST
        $.ajax({
            type : "POST",
            contentType : "application/json; charset=utf-8",
            url : "supplierMeterial", //window.location +"supplierMeterial",
            data : JSON.stringify(formData),
            dataType : 'json',
            success : function(res) {

                if(res.status == 200) {
                                swal({type:'success', title:'Success', text:'Successfully Added '});

                            }
//                if (res.error){
//                    swal({title:"Error", text:res.error, type:"error"});
//                }
//                else{
//                    swal({title:"Success", text:"Your Account Has Been Created. Please Login", type:"success"});
//                    resetData();
//                }
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

    function resetData(){
        $("#supplierMaterialType").val("");
        $("#measurement").val("");
        $("#unitPrice").val("");
        $("#supplierID").val("");
    }

    /////////////////////////////////////////////////////////////////////////////////

    // GET USER BY ID(search)
    $("#searchBtn").click(function(event){
        event.preventDefault();
        var id = $("#searchTxt").val();

        ajaxGetSupplierMaterialById(id);
    });

    // DO GET
    function ajaxGetSupplierMaterialById(id){
        $.ajax({
            type : "GET",
            url : "supplierMeterial/"+id,
            success: function(result){
                if(result){
                    $("#supplierMaterialType").val(result.supplierMaterialType);
                    $("#measurement").val(result.measurement);
                    $("#unitPrice").val(result.unitPrice);
                    $("#supplierID").val(result.supplierID);

                console.log("Success: ", result);
                }else{
                    $("#searchTxt").val("Material not found");
                    console.log("Fail: ", result);
                }
            },
            error : function(e) {
                $("#searchTxt").val("Material not found");
                console.log("ERROR: ", e);
            }
        });
    }

    /////////////////////////////////////////////////////////////




    ///////////////////////////////////////////////////////////////////////////

    // DELETE USER BY ID
    $("#searchBtn").click(function(event){
        event.preventDefault();
        var id = $("#searchTxt").val();

        ajaxDeleteSupplierMaterialById(id);
    });

    // DO DELETE
    function ajaxDeleteSupplierMaterialById(id){
        $.ajax({
            type : "DELETE",
            url : "supplierMeterial/"+id,
            success: function(result){
                if(result){

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

});
