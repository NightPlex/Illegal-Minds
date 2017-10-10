/**
 * Created by steven.tihomirov on 12.7.2017.
 */

//Taking it to AJAX

function makeDrink() {
    $.post( "/", function() {
        alert( "success" );
    })
        .done(function() {
            alert( "second success" );
        })
        .fail(function() {
            alert( "error" );
        })
        .always(function() {
            alert( "finished" );
        });
}