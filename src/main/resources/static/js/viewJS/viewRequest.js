$(document).ready(function() {
    //request
    $('a.manageRequest').click( function () {
        $("#body").load('/manageRequest.html'), function () {
            $.getScript('/js/viewJS/manageRequest.js');
        }
    });
});