$( document ).ready(() => {

    $.ajax({
        url: "http://localhost:9000/place",
        method: "GET"

    }).done(function (data) {
        debugger;
        
        /*
        Todo lo que se programa dentro de esta función
        será ejecutado cuando se haya resuelto la 
        petición asíncrona, es decir, cuando llegue
        la respuesta del servidor.
        */

        /*
        JSON.parse() toma como entrada el texto en JSON 
        que me llega del servidor y lo convierte a un objeto
        */

        let json = JSON.parse(data);
        
        debugger;
    });

});