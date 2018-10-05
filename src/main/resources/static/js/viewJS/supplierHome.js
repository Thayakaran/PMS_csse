$(document).ready(function(){
    var username = localStorage.getItem('name');
    document.getElementById("userwelcome").innerHTML = username;
    document.getElementById("username").innerHTML = username;

    $("#logout1, #logout2").click(function () {
        localStorage.clear();
        location.href = "/";
      });
    //register invoice
    $('#invoiceSubmitBtn').click(function () {
        $("#body").load('/invoice.html', function() {
            $.getScript('/js/viewJS/invoice.js');
        });
    });

       //register supplier material
        $('#supplierMaterial').click(function () {
            $("#body").load('/supplierMeterial.html', function() {
                $.getScript('/js/viewJS/supplierMaterial.js');
            });
        });
});