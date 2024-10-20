import { Component, OnInit } from '@angular/core';
import { Curso } from '../../interfaces/curso';
import { CursoService } from '../../services/curso.service';

@Component({
  selector: 'app-listado-cursos',
  templateUrl: './listado-cursos.component.html',
  styleUrl: './listado-cursos.component.css'
})
export class ListadoCursosComponent implements OnInit{

  listaCursos: Curso[] = [];

  constructor(private service: CursoService) {}


  getCursos() {

    this.service.getCursos().subscribe((res) => {

      this.listaCursos = res;
    })
  }

  ngOnInit(): void {
      
    this.getCursos();
  }


}
