import { Component, EventEmitter, Input, OnChanges, Output, SimpleChanges } from '@angular/core';
import { Atacar, Pokemon } from '../../models/pokemon.interface';
import { AnimationOptions } from 'ngx-lottie';
import { AnimationItem } from 'lottie-web';

@Component({
  selector: 'app-pokemon',
  templateUrl: './pokemon.component.html',
  styleUrl: './pokemon.component.css'
})
export class PokemonComponent implements OnChanges{
  animationCreated($event: AnimationItem) {
  
    console.log($event);
  }

  
  @Input()
  pokemon: Pokemon | undefined;
  @Output()
  pokemonChecked = new EventEmitter<Pokemon>();

  options: AnimationOptions = {
    path: '/assets/animation_boom.json'
  }

  onCheck(pokemon: Pokemon | undefined) {

    this.pokemonChecked.emit(pokemon);
  }

  ngOnChanges(changes: SimpleChanges): void {
   
    debugger;
  }
}
