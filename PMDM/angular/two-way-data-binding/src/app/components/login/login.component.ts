import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  //1. Property binding

  valoracion = 5;
  imgUrl = "https://upload.wikimedia.org/wikipedia/commons/2/2d/El_mercachifle_%281850%29.jpg";

  userInfo = "";

  //2. Event binding

  showUserInfo() {

    this.userInfo = "Usuario: admin, Contraseña: 1234"
    alert(`Nombre de usuario: ${this.nombre}`);
  }

  //3. Two way data binding

  nombre = "Sergio"
}
