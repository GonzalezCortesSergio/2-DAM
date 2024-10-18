import { Component, OnInit } from '@angular/core';
import { House } from '../../interfaces/house.interface';
import { HouseService } from '../../services/house.service';

@Component({
  selector: 'app-house-list',
  templateUrl: './house-list.component.html',
  styleUrl: './house-list.component.css'
})
export class HouseListComponent implements OnInit{

  constructor(private houseService: HouseService) {}
  


  listadoCasas: House[] = [];

  getHouses() {

    this.houseService.getHouses().subscribe((result) => {

      this.listadoCasas = result;
    })
  }

  ngOnInit(): void {

    this.getHouses()
  }



}
