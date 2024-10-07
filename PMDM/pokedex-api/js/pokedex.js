$(document).ready(() => {

    $.ajax({
        url: "https://pokeapi.co/api/v2/pokemon/",
        method: "GET"
    }).done(function (resp) {

        let listadoPokemon = resp.results;

        listadoPokemon.forEach((pokemon, index) => {

            var template = `
            
            <div class="card col-12 col-xl-2 my-3 border-danger">
              <img class="card-img-top mx-2 my-3 w-75" src="https://raw.githubusercontent.com/PokeAPI/sprites/refs/heads/master/sprites/pokemon/${index + 1}.png" />
              <h3 class="h5 text-center">Nº${index + 1}</h3>
              <div class="card-body w-100">
                <h4 class="card-title text-center">${pokemon.name.capitalize()}</h4>
                <div class="card-text d-flex justify-content-around">
                  <div class="planta w-50">
                    <p class="text-center my-auto">Planta</p>
                  </div>
                  <div class="veneno w-50">
                    <p class="text-center my-auto">Veneno</p>
                  </div>
                </div>
              </div>
            </div>
            `
            $("main div.row").append(template)
        });

        

    });
});

Object.defineProperty(String.prototype, 'capitalize', {
    value: function() {
      return this.charAt(0).toUpperCase() + this.slice(1);
    },
    enumerable: false
  });