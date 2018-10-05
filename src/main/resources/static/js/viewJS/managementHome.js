var userRole = localStorage.getItem('role');
if (userRole == null || userRole != "Manager") {
    location.href = "/";
}

$(document).ready(function(){

    var username = localStorage.getItem('userName');
    document.getElementById("userwelcome").innerHTML = username;
    document.getElementById("username").innerHTML = username;

    $("#logout").click(function () {
        localStorage.clear();
        location.href = "/";
      });
    //Manage users
    $('#userManagement').click(function () {
        $("#body").load('/userManagement', function() {
            $.getScript('/js/viewJS/userManagement.js');
        });
    });
    if(localStorage.getItem('nav') == "addUser"){
        $("#body").load('/userManagement', function() {
            $.getScript('/js/viewJS/userManagement.js');
        });
        localStorage.removeItem('nav');
    }

    //Manage sites
    $('#siteManagement').click(function () {
        $("#body").load('/siteManagement', function() {
            $.getScript('/js/viewJS/siteManagement.js');
        });
    });
});