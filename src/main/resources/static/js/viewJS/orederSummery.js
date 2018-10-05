$(document).ready(function(){
    $("tableSelector").delegate("tr.rows", "click", function(){
        alert("Click!");
    });
});

