import { Component, OnInit } from '@angular/core';
import { Alumno } from '../../interfaces/alumno';
import { AlumnoService } from '../../services/alumno.service';

@Component({
  selector: 'app-listado-alumnos',
  templateUrl: './listado-alumnos.component.html',
  styleUrl: './listado-alumnos.component.css'
})
export class ListadoAlumnosComponent implements OnInit{

  listadoAlumnos: Alumno[] = []

  constructor(private service: AlumnoService) {}

  getAlumnos() {

    this.service.getAlumnos().subscribe((result) => {

      this.listadoAlumnos = result;
    })
  }

  ngOnInit(): void {
      
    this.getAlumnos();
  }

}
