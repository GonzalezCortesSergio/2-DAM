import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pokemon, PokemonResponse } from '../interfaces/pokemon';

@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  API_URL = "https://pokeapi.co/api/v2/pokemon/";

  constructor(private http: HttpClient) { }

  getPokemonList(): Observable<PokemonResponse> {

    return this.http.get(this.API_URL) as Observable<PokemonResponse>;
  }

  getPokemon(pokemonUrl: string): Observable<Pokemon> {

    return this.http.get(pokemonUrl) as Observable<Pokemon>;
  }
}
