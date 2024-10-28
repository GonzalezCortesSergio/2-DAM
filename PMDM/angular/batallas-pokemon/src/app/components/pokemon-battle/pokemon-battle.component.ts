import { Component, OnInit } from '@angular/core';
import { Atacar, Pokemon } from '../../models/pokemon.interface';
import { PokemonService } from '../../services/pokemon.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-pokemon-battle',
  templateUrl: './pokemon-battle.component.html',
  styleUrl: './pokemon-battle.component.css'
})
export class PokemonBattleComponent implements OnInit{

  turno = false;
  dmg = 0;
  history: string[] = [];

  pokemonId: string | null = "";
  pokemonId2: string | null = "";

  pokemon1: Pokemon | undefined;
  pokemon2: Pokemon | undefined;

  constructor(private route: ActivatedRoute, private service: PokemonService) {}

  ngOnInit(): void {
      this.pokemonId = this.route.snapshot.paramMap.get('id');
      this.pokemonId2 = this.route.snapshot.paramMap.get('id2');

      this.service.getOnePokemon(parseInt(this.pokemonId!)).subscribe(res => {

        this.pokemon1 = res;
      })
      this.service.getOnePokemon(parseInt(this.pokemonId2!)).subscribe(res => {

        this.pokemon2 = res;
      })
  }
  atacar() {
    this.dmg = Math.floor(Math.random() * (20 - 1 + 1) + 1);
    if(this.turno) {

      this.pokemon2!.stats[0].base_stat-= this.dmg;
      this.history.push(this.pokemon1!.name + " ha hecho " + this.dmg + " de daño");
    }

    else {

      this.pokemon1!.stats[0].base_stat-= this.dmg;
      this.history.push(this.pokemon2!.name + " ha hecho " + this.dmg + " de daño");
    }
    
    this.turno = this.turno == true ? false: true;
    

  }

  
}
