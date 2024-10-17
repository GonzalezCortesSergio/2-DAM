import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-custom-progress-bar-2',
  templateUrl: './custom-progress-bar-2.component.html',
  styleUrl: './custom-progress-bar-2.component.css'
})
export class CustomProgressBar2Component {

  @Input()
  valor = 0;

  getProgressColor(): string {

    if(this.valor <= 25) {
      
      return 'danger';
    }
    else if (this.valor >= 25 && this.valor <= 50) {

      return 'warning';
    }

    else if (this.valor >= 50 && this.valor <= 75){

      return 'primary';
    }

    else {

      return 'success'
    }
  }
}
