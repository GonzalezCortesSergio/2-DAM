import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

  constructor(private authService: AuthService){}


  iniciaSesion(){
    this.authService.createRequestToken().subscribe(res => {
      
      localStorage.setItem("token", res.request_token)

      window.location.href = `https://www.themoviedb.org/authenticate/${res.request_token}?redirect_to=http://localhost:4200/aproved`;
    })
  }
}
