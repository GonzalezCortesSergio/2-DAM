$(document).ready(() => {

    cargarTodosPokemonV2();
});

function cargarTodosPokemonV2() {

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
            
            <div class="text-center w-50 mx-auto">
              <button class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#modal-detalles-${index + 1}">Más info</button>
            </div>
          </div>

          
        </div>
        
        `

        var modal = `
        <!-- The Modal -->
          <div class="modal fade" id="modal-detalles-${index + 1}">
            <div class="modal-dialog">
              <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                  <h4 class="modal-title">Modal Heading</h4>
                  <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                  Modal body..
                </div>

                <!-- Modal footer -->
                <div class="modal-footer">
                  <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                </div>

              </div>
            </div>
          </div>
        `
        $("main div.row").append(template)

        $("body").append(modal);
    });

    

});

}

function verDetallesPokemon(evento) {

  $.ajax({
    
  })

}

Object.defineProperty(String.prototype, 'capitalize', {
    value: function() {
      return this.charAt(0).toUpperCase() + this.slice(1);
    },
    enumerable: false
  });