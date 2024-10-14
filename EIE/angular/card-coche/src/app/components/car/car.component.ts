import { Component } from '@angular/core';

@Component({
  selector: 'app-car',
  templateUrl: './car.component.html',
  styleUrl: './car.component.css'
})
export class CarComponent {

  photoUrl = "coche_1.png";
  title = "Toyota GR"
  type = "Automatic/Manual"
  prize = "$85/day"
}
