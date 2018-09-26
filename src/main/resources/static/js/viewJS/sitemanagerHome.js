$(document).ready(function(){
    var username = localStorage.getItem('name');
    document.getElementById("userwelcome").innerHTML = username;
    document.getElementById("username").innerHTML = username;

    $("#logout1, #logout2").click(function () {
        localStorage.clear();
        location.href = "/";
    });
    //view request
    $('#viewRequest').click(function () {
        $("#body").load('/viewRequests.html');
    // , function() {
    //         // $.getScript('/js/viewJS/viewRequest.js');
    //     }
    });
});