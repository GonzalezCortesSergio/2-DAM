import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MonumentosService {

  API = "http://localhost:9000/api/monumentos"
  constructor(private httpClient: HttpClient) { }

  getMonumentos() {

    return this.httpClient.get(this.API).pipe(res => res);

  }
}
