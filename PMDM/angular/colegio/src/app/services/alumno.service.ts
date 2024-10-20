import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Alumno } from '../interfaces/alumno';

@Injectable({
  providedIn: 'root'
})
export class AlumnoService {
  API_URL = "http://localhost:9000/api/alumno"

  constructor(private http: HttpClient) { }


  getAlumnos(): Observable<Alumno[]> {

    return this.http.get(this.API_URL) as Observable<Alumno[]>;
  }
}
