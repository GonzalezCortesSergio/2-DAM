import { Component } from '@angular/core';
import { AlumnoDto } from '../../models/alumno.dto';

@Component({
  selector: 'app-alumno-add-form',
  templateUrl: './alumno-add-form.component.html',
  styleUrl: './alumno-add-form.component.css'
})
export class AlumnoAddFormComponent {

  cursos = ["1ºDAM", "2ºDAM", "1ºAYF", "2ºAYF"];

  student = new AlumnoDto("Sergio", this.cursos[1], 19, "671097511");

  addStudent(): void {

    console.log(this.student);
  }

}
