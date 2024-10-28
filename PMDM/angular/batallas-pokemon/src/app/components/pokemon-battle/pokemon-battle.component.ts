import { Component, OnInit } from '@angular/core';
import { Atacar, Pokemon } from '../../models/pokemon.interface';
import { PokemonService } from '../../services/pokemon.service';

@Component({
  selector: 'app-pokemon-battle',
  templateUrl: './pokemon-battle.component.html',
  styleUrl: './pokemon-battle.component.css'
})
export class PokemonBattleComponent implements OnInit{

  turno = false;

  attackPokemon($event: Atacar) {
  this.pokemonBattle.forEach(pokemon => {
    
    if(pokemon.id != $event.pokemonId) {

      pokemon.stats[0].base_stat -=$event.danio;
    }
  })
  
}

  listadoPokemon: Pokemon[] = [];
  pokemonBattle: Pokemon[] = [];

  constructor(private service: PokemonService) {}

  ngOnInit(): void {
      
    this.getPokemonList();
    console.log(this.listadoPokemon);
    this.listadoPokemon.forEach(pokemon =>{

      if(pokemon.id == 1 || pokemon.id == 4){

        this.pokemonBattle.push(pokemon);
      }
    })

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
}
