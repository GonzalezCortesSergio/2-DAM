$( document ).ready(() => {

    $("h1").css("background-color", "red")
        .css("border-radius", "15px")
        .html("Adiós mundo")
        .css("margin", "0 auto")
        .css("text-align", "center")


    $(".hola").html("Holi")
    .css("margin", "0 auto")
    .css("text-align", "center")
    .css("font-size", "36pt")
    .css("background-color", "palegreen")
    .css("padding-top", "15px")
    .css("padding-bottom", "15px"
    )
    .css("border-radius", "36px")
    .css("margin-top", "25px")


    //Evento click

    $(document).on("click", "#btn-clear", () => {


        $("h1").html("")
    })

    $(document).on("click", "#btn-restore", () => {

        $("h1").html("Adiós mundo")
    })

    $(document).on("click", ".btn-yellow", () => {

        $("h1").addClass("yellow")
    })

    $(document).on("click", ".remove-yellow", () => {

        $("h1").removeClass("yellow")
    })
});