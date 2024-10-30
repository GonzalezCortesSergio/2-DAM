import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

  titulo = "Bienvenido A La Página de Inicio";

  precio = 125.75;

  createdAt = '2021-05-24';

  porcentajeVida = 0.75;
}
