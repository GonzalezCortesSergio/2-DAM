import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Atacar, Pokemon } from '../../models/pokemon.interface';

@Component({
  selector: 'app-pokemon',
  templateUrl: './pokemon.component.html',
  styleUrl: './pokemon.component.css'
})
export class PokemonComponent {

  
  @Input()
  pokemon: Pokemon | undefined;
  @Output()
  pokemonChecked = new EventEmitter<Pokemon>();

  onCheck(pokemon: Pokemon | undefined) {

    this.pokemonChecked.emit(pokemon);
  }
}
