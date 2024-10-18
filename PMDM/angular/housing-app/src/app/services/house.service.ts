import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { House } from '../interfaces/house.interface';

@Injectable({
  providedIn: 'root'
})
export class HouseService {

  constructor(private httpClient: HttpClient) { }

  API_URL = 'http://localhost:3000/house-list';

  
  getHouses(): Observable<House[]> {

    return (this.httpClient.get(this.API_URL) as Observable<House[]>);

  }
}
