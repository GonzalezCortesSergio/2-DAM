import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FilmResponse } from '../models/film.interface';

@Injectable({
  providedIn: 'root'
})
export class FilmService {

  API_URL = "https://swapi.dev/api/films";

  constructor(private http: HttpClient) { }

  getFilms(): Observable<FilmResponse> {

    return this.http.get(this.API_URL) as Observable<FilmResponse>;
  }
}
