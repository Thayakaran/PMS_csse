$(document).ready(function(){
    var username = localStorage.getItem('name');
    document.getElementById("userwelcome").innerHTML = username;
    document.getElementById("username").innerHTML = username;

    $("#logout1, #logout2").click(function () {
        localStorage.clear();
        location.href = "/";
      });
    //register users
    $('#userManagement').click(function () {
        $("#body").load('/userManagement.html', function() {
            $.getScript('/js/viewJS/userManagement.js');
        });
    });
});