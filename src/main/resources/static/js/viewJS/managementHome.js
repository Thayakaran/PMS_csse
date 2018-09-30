$(document).ready(function(){
    var username = localStorage.getItem('name');
    document.getElementById("userwelcome").innerHTML = username;
    document.getElementById("username").innerHTML = username;

    $("#logout1, #logout2").click(function () {
        localStorage.clear();
        location.href = "/";
      });
    //Manage users
    $('#userManagement').click(function () {
        $("#body").load('/userManagement.html', function() {
            $.getScript('/js/viewJS/userManagement.js');
        });
    });

    //Manage sites
    $('#siteManagement').click(function () {
        $("#body").load('/siteManagement.html', function() {
            $.getScript('/js/viewJS/siteManagement.js');
        });
    });
});