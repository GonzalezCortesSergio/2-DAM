import { Component } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrl: './calculator.component.css'
})
export class CalculatorComponent {

  value = 0;
  calculichi = "";

  addNum(arg0: number) {
    
    this.calculichi+= arg0;
  }

  sumar() {
    this.calculichi+= "+";
  }

  restar() {
    this.calculichi+="-";
  }

  multiplicar() {
    this.calculichi+="*";
  }
  dividir() {
    this.calculichi+="/";
  }

  resultado() {
    this.value = eval(this.calculichi);
    this.calculichi = this.value.toString();
  }

  borrar() {

    this.value = 0;

    this.calculichi = "";
  }

  addFloat() {

    this.calculichi+="."
  }

  borrarCaracter() {

    this.calculichi.slice(0, this.calculichi.length - 2);
  }


  
}
