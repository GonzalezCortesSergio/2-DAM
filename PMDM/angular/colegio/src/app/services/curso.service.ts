import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Curso } from '../interfaces/curso';

@Injectable({
  providedIn: 'root'
})
export class CursoService {

  API_URL = "http://localhost:9000/api/curso"
  constructor(private http: HttpClient) { }

  getCursos(): Observable<Curso[]> {

    return this.http.get(this.API_URL) as Observable<Curso[]>;
  }
}
