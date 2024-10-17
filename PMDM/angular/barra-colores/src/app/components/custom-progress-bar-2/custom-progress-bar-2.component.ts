import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-custom-progress-bar-2',
  templateUrl: './custom-progress-bar-2.component.html',
  styleUrl: './custom-progress-bar-2.component.css'
})
export class CustomProgressBar2Component {

  @Input() 
  value = 0;

  @Input()
  color = "primary";


  getWidth() {

    return `width: ${this.value}%;`;
  }

  getColor() {

    return `color: ${this.color};`
  }
}
