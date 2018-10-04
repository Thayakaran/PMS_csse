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
        $("#body").load('/sitemanagerHome.html'), function() {
            $.getScript('/js/viewJS/viewRequest.js');
        }
    });

    //request
    $('#Request').click(function () {
        $("#body").load('/request.html'), function() {
                 $.getScript('/js/viewJS/request.js');
           }
    });

    //request
    $('#manageRequest').click(function () {
        $("#body").load('/manageRequest.html'), function () {
            $.getScript('/js/viewJS/manageRequest.js');
        }
    });
});