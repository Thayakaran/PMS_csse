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
            $.getScript('/js/viewJS/register.js');
        });
    });
    // form 1
    // $('#registerUser').click(function () {
    //     $("#body").load('/form1.html', function() {
    //         $.getScript('/js/viewJS/form1.js');
    //     });
    //   });

    // form 3 
    // $('.form_I_3').click(function () {
    //     $("#forms").load('form3.html', function() {
    //         $.getScript('/build/js/form3.js');
    //     });
    //   });
});