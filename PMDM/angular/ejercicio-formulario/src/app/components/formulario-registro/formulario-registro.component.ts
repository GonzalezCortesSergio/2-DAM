import { Component, OnInit } from '@angular/core';
import { UsuarioDto } from '../../models/usuario.dto';
import { AbstractControl, FormControl, FormGroup, ValidationErrors, ValidatorFn, Validators, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-formulario-registro',
  templateUrl: './formulario-registro.component.html',
  styleUrl: './formulario-registro.component.css'
})
export class FormularioRegistroComponent {

  
  usuario = new UsuarioDto('', '', '', '', '', '', '', '');

  calcularLetra(nif: string): string {

    let letrasDni = [
      "T", "R", "W", "A", "G",
      "M", "Y", "F", "P", "D",
      "X", "B", "N", "J", "Z",
      "S", "Q", "V", "H", "L",
      "C", "K", "E"
    ];

    let nifInt = parseInt(nif);

    return letrasDni[nifInt % 23];
  }

  enviar(): void {

    console.log(this.usuario);
  }
  confirmPasswordValidator: ValidatorFn = (control: AbstractControl): ValidationErrors | null => {
    return control.value.password === control.value.confirmPassword ? null: {PasswordNoMatch: true};
  };

  passwordForm: FormGroup = new FormGroup({
    password: new FormControl<string>('', [Validators.required]),
    confirmPassword: new FormControl<string>('', [Validators.required]),
    
  }, {validators: this.confirmPasswordValidator});

  
}
