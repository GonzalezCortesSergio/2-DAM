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
  atacar = new EventEmitter<Atacar>();

  attack(pokemon: Pokemon | undefined) {

    let atacar: Atacar = {
      pokemonId: pokemon?.id,
      danio: 2
    };
    
    this.atacar.emit(atacar);
  }
}
