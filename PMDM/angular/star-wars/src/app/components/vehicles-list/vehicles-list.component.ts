import { Component, OnInit } from '@angular/core';
import { Vehicle } from '../../interfaces/vehicle';
import { VehiclesService } from '../../services/vehicles.service';
import { Result } from '../../interfaces/result';

@Component({
  selector: 'app-vehicles-list',
  templateUrl: './vehicles-list.component.html',
  styleUrl: './vehicles-list.component.css'
})
export class VehiclesListComponent implements OnInit{

  constructor(private vehicleService: VehiclesService) {}

  
  vehiclesList: Vehicle[] = []
  

  getVehicles() {

    this.vehicleService.getVehicles().subscribe((res) => {
      let result:Result = res;
      this.vehiclesList = result.results;
    })
  }

  ngOnInit() {

    this.getVehicles()

  }

  getImage(vehicle: Vehicle):string {

    let id = parseInt(vehicle.url.slice(31,32));

    return `https://starwars-visualguide.com/assets/img/vehicles/${id}.jpg`
  }
}
