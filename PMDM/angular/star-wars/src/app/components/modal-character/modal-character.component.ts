import { Component, inject, Input } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Character } from '../../interfaces/people';

@Component({
  selector: 'app-modal-character',
  templateUrl: './modal-character.component.html',
  styleUrl: './modal-character.component.css'
})
export class ModalCharacterComponent {

  activeModal = inject(NgbActiveModal);

  @Input()
  character: Character = 
  {
    name: "",
    height: "string",
    mass: "string",
    hair_color: "string",
    skin_color: "string",
    eye_color: "string",
    birth_year: "string",
    gender: "string",
    homeworld: "string",
    films: [],
    species: [],
    vehicles: [],
    starships: [],
    created: "string",
    edited: "string",
    url: "string",
  }

  getImage(character: Character):string {

    let id = parseInt(character.url.slice(29,30));

    return `https://starwars-visualguide.com/assets/img/characters/${id}.jpg`
  }
}
