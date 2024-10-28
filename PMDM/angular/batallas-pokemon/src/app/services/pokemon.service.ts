import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pokemon, PokemonResponse } from '../models/pokemon.interface';

@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  API_URL = "https://pokeapi.co/api/v2/pokemon";

  constructor(private http: HttpClient) { }

  getPokemonResponse(): Observable<PokemonResponse>{

    return this.http.get(this.API_URL) as Observable<PokemonResponse>;
  }

  getPokemon(pokemonUrl: string): Observable<Pokemon> {

    return this.http.get(pokemonUrl) as Observable<Pokemon>;
  }

  getOnePokemon(pokemonId: number): Observable<Pokemon> {

    return this.http.get(`${this.API_URL}/${pokemonId}`) as Observable<Pokemon>;
  }
}
