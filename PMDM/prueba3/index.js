$( document ).ready(() => {
    
    let frase = ["Hola comostamo", "Buenas tardes Manolo", "Holi", "Ea"];

    $(document).on("click", "#btn-add-paragraph", () => {

        $("#content").append("<p>" + frase[Math.floor(Math.random()*(3-0+1))] + "</p>")
    })


});