import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Vehicle } from '../interfaces/vehicle';
import { Result } from '../interfaces/result';

@Injectable({
  providedIn: 'root'
})
export class VehiclesService {

  API_URL = "https://swapi.dev/api/vehicles/";
  
  constructor(private http: HttpClient) { }

  getVehicles(){

    return this.http.get(this.API_URL) as Observable<Result>;
  }
}
