$(document).ready(function(){
    var username = localStorage.getItem('name');
    document.getElementById("userwelcome").innerHTML = username;
    document.getElementById("username").innerHTML = username;

    $("#logout1, #logout2").click(function () {
        localStorage.clear();
        location.href = "/";
      });
    //register users
    $('#registerUser').click(function () {
        $("#body").load('/registration.html', function() {
            $.getScript('/js/viewJS/registration.js');
        });
    });
});