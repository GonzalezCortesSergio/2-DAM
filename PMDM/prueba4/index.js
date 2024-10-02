$(document).ready(() => {
    let i = 1;

    $(document).on("click", "#btn-add-paragraph", () => {
        
        $("#content").append("<div class='content-paragraph'> <p> " + i++ + 
            ". Lorem ipsum</p> <button class='remove-btn'>Remove</button> </div>")
    
        
    });

    $(document).on("click", ".remove-btn", function() {

        $(this).parent().remove();
    });

});