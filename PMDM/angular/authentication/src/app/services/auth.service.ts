import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Token } from '../models/interfaces/create-request-token.interface';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  //STEP 1: Pedir token 

  createRequestToken(): Observable<Token> {

    return this.http.get<Token>(`https://api.themoviedb.org/3/authentication/token/new?api_key=a73172f9b2f5f84377847c5a9d76d375`);
  }


  //STEP 2: Crear session ID

  createSession(): Observable<any> {

    return this.http.post("https://api.themoviedb.org/3/authentication/session/new?api_key=a73172f9b2f5f84377847c5a9d76d375", {
      request_token: localStorage.getItem("token")
    })
  }
}
