$( document ).ready(() => {

    $.ajax({
        url: "https://pokeapi.co/api/v2/pokemon/",
        method: "GET"

    }).done(function (resp) {
        
        let listadoPokemon = resp.results;
        

        listadoPokemon.forEach((pokemon, index) => {
            
            var template = `
                <p>

                    <h1 class="pokemon" pokemonid="1">
                        ${pokemon.name}
                        <div>
                            <img src="https://raw.githubusercontent.com/PokeAPI/sprites/refs/heads/master/sprites/pokemon/${index + 1}.png" />
                        </div>
                    </h1>
                </p>
            `

            $("#data-content").append(template);
            console.log(pokemon)
        });
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

    
    });

});