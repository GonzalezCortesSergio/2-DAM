import { Component, inject, Input } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Vehicle } from '../../interfaces/vehicle';

@Component({
  selector: 'app-modal-vehcile',
  templateUrl: './modal-vehcile.component.html',
  styleUrl: './modal-vehcile.component.css'
})
export class ModalVehcileComponent {

  activeModal = inject(NgbActiveModal);
  @Input() vehicle: Vehicle = 
  {
    name: "",
    model: "", 
    manufacturer: "", 
    cost_in_credits: "", 
    length: "", 
    max_atmosphering_speed: "", 
    crew: "",
    passengers: "",
    cargo_capacity: "",
    consumables: "",
    vehicle_class: "",
    pilots: [],
    films: [],
    created: "",
    edited: "",
    url: ""
  }

  getImage(vehicle: Vehicle):string {

    let id = parseInt(vehicle.url.slice(31,32));

    return `https://starwars-visualguide.com/assets/img/vehicles/${id}.jpg`
  }
}
