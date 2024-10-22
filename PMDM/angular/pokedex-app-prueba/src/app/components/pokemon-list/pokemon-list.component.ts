import { Component, inject, OnInit } from '@angular/core';
import { Pokemon, PokemonPreview } from '../../interfaces/pokemon';
import { PokemonService } from '../../services/pokemon.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { map } from 'rxjs';
import { PokemonModalComponent } from '../pokemon-modal/pokemon-modal.component';

@Component({
  selector: 'app-pokemon-list',
  templateUrl: './pokemon-list.component.html',
  styleUrl: './pokemon-list.component.css'
})
export class PokemonListComponent implements OnInit{

  listaPokemon: PokemonPreview[] = []

  private modalService = inject(NgbModal);

  constructor(private service: PokemonService) {}

  getPokemonList(): void {

    this.service.getPokemonList().subscribe(res => {

      this.listaPokemon = res.results;
    })
  }

  getImage(pokemon: PokemonPreview): string {

    let id = parseInt(pokemon.url.slice(-2, -1))
    return `https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/${id}.gif`;
  }

  openModal(pokemonUrl: string) {

    const modalRef = this.modalService.open(PokemonModalComponent);

    this.service.getPokemon(pokemonUrl).subscribe(res => {

      modalRef.componentInstance.pokemon = res;
    })
  }
  capitalizeFirstLetter(string: string) {
    return string.charAt(0).toUpperCase() + string.slice(1);
  }

  ngOnInit(): void {
      this.getPokemonList();
  }

}
