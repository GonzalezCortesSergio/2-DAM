import { Component, OnInit } from '@angular/core';
import { Monumentos } from '../../interfaces/monumentos';
import { MonumentosService } from '../../services/monumentos.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-monumentos',
  templateUrl: './monumentos.component.html',
  styleUrl: './monumentos.component.css'
})
export class MonumentosComponent implements OnInit{
  
  constructor(private monumentosService: MonumentosService) {}

  listaMonumentos: Monumentos[] = [];

  ngOnInit(): void {
    
    this.getMonumentos();

  }

  getMonumentos() {

    this.monumentosService.getMonumentos().subscribe({
      next: (result) => {

        this.listaMonumentos = (result as Monumentos[]);
      },
      error: (err) => {

        console.log(err);
      }
    })

  }
}
