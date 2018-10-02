$(document).ready(function() {

    //request
    $('#Request').submit(function () {
        $("#body").load('/manageRequest.html'), function () {
            $.getScript('/js/viewJS/manageRequest.js');
        }
    });
});