import { Component } from '@angular/core';
import { Pokemon } from '../../models/pokemon.interface';
import { PokemonService } from '../../services/pokemon.service';

@Component({
  selector: 'app-pokemon-list',
  templateUrl: './pokemon-list.component.html',
  styleUrl: './pokemon-list.component.css'
})
export class PokemonListComponent {


  listadoPokemon: Pokemon[] = [];
  pokemonBattle: Pokemon[] = [];

  constructor(private service: PokemonService) {}

  ngOnInit(): void {
      
    this.getPokemonList();
    console.log(this.listadoPokemon);

  }

  getPokemonList(): void{
    this.service.getPokemonResponse().subscribe(response => {

      response.results.forEach(pokemonPreview => {

        this.service.getPokemon(pokemonPreview.url).subscribe(pokemon=> {

          this.listadoPokemon.push(pokemon);
        })
      })
    })
  }

  addToBattle($event: Pokemon) {
  
    if(this.pokemonBattle.includes($event)) {

      let indexToDelete = this.pokemonBattle.indexOf($event);
      this.pokemonBattle.splice(indexToDelete, 1);
    }else {

      this.pokemonBattle.push($event);
    }
    
  }
}
