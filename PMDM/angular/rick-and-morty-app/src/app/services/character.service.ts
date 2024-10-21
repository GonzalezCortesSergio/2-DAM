import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CharactersResponsible, Episode } from '../interfaces/characters';

@Injectable({
  providedIn: 'root'
})
export class CharacterService {

  API_URL = "https://rickandmortyapi.com/api/character/";
  constructor(private http: HttpClient) { }

  getCharacters(): Observable<CharactersResponsible> {

    return this.http.get(this.API_URL) as Observable<CharactersResponsible>;
  }

  getFirstEpisode(episode: string): Observable<Episode> {

    return this.http.get(episode) as Observable<Episode>
  }

}
