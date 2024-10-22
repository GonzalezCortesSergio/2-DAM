import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Character } from '../interfaces/people';
import { Result, ResultPeople } from '../interfaces/result';

@Injectable({
  providedIn: 'root'
})
export class PeopleService {

  API_URL = "https://swapi.dev/api/people/"
  constructor(private http: HttpClient) { }


  getPeople(): Observable<ResultPeople> {

    return this.http.get(this.API_URL) as Observable<ResultPeople>
  }
}
