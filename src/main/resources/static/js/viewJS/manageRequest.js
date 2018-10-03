$(document).ready(function() {

    $("#managependingRequest").submit(function(event){
        event.preventDefault();
        var id = $("#Request_id").val();
        console.log(id);

        ajaxGetRequestId(id);
    });

    // DO GET
    function ajaxGetRequestId(id){
        $.ajax({
            type : "GET",
            url : "/sitemanager/8", //+id,
            success: function(result){
                if(result){
                    $("#Requester_id").val(result.orderby),
                        $("#site_name").val(result.site),
                        $("#manager_name").val(result.manager),
                        $("#Order_date").val(result.date),
                        $("#require_date").val(result.requiredate),
                        $("#item").val(result.item),
                        $("#qty").val(result.qty),
                        $("#description").val(result.description),
                        $("#contact").val(result.contactnum),
                        $("#order_status").val(result.status)

                    console.log("Success: ", result);
                }else{
                    $("#Request_id").val("User not found");
                    console.log("Fail: ", result);
                }
            },
            error : function(e) {
                $("#Request_id").val("User not found");
                console.log("ERROR: ", e);
            }
        });
    }

});
