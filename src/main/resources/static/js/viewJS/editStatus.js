$(document).ready(function () {

    var pageURL = $(location).attr("href");



    var orderID = localStorage.getItem("id");
     var status = localStorage.getItem("status");




    var email = localStorage.getItem('email');




    $('#id').val(orderID);
    $('#status').val(status);
    alert(id , status);
//    localStorage.removeItem("status");
//    localStorage.removeItem("id");

    $("#statusedi").click(function () {

        updateOrderStatus();

    });




// order status when supplier change the status
    function updateOrderStatus() {

        var status = {
            id : $("#id").val(),
            status : $("#status").val()
        }


        $.ajax({
            type : "PUT",
            contentType : "application/json",
            url : "/orders/status",
            data : JSON.stringify(status),
            success : function(res) {
                if (res.error){
                    swal({title:"Error", text: "Unable to set the order status", type:"error"});
                }
                else{
                    swal({title:"Success", text:"order status successfully updated", type:"success"});
                    window.location.replace("http://localhost:3000/orderSummery.html");
                }
            },
            error : function (error) {
                console.log("error" + error);
            }

        });

    }


});