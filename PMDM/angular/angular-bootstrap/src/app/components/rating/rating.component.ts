import { Component } from '@angular/core';

@Component({
  selector: 'app-rating',
  templateUrl: './rating.component.html',
  styleUrl: './rating.component.css'
})
export class RatingComponent {

  valoracion = 4;
  colorichi = "red"
  calcRating() {

    this.colorichi = this.valoracion < 5 ? "red" : "green"

  }
}
