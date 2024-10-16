import { Component } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';

export interface Student{

  nAlumno: number;
  nombre: string;
  apellidos: string;
  nif: string;
  edad: number;
  curso: string;

}

const ALUMNOS: Student[] = [
  {nAlumno: 1, nombre: "Álvaro", apellidos: "Castilla Cano", nif: "21343607M", edad: 19, curso: "2ºDAM"},
  {nAlumno: 2, nombre: "Patricia", apellidos: "Alonso Ayllón", nif: "62343484K", edad: 22, curso: "2ºDAM"},
  {nAlumno: 3, nombre: "Miguel", apellidos: "Garfia Bermúdez", nif: "21113237AWELA", edad: 22, curso: "2ºDAM(no sabe ni como)"},
  {nAlumno: 4, nombre: "Sergio", apellidos: "González Cortés", nif: "31232432F", edad: 19, curso: "2ºDAM"},
  {nAlumno: 5, nombre: "Pedro", apellidos: "Sánchez del Bot", nif: "09344507A", edad: 20, curso: "2ºDAM"},

];


@Component({
  selector: 'app-tabla',
  templateUrl: './tabla.component.html',
  styleUrl: './tabla.component.css'
})
export class TablaComponent {


  displayedColumns = ["nAlumno", "nombre", "apellidos"
    , "nif", "edad", "curso"
  ]

  listadoAlumnos = new MatTableDataSource(ALUMNOS);
  

}
