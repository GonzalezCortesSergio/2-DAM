import { Component, inject, OnInit } from '@angular/core';
import { Character } from '../../interfaces/people';
import { PeopleService } from '../../services/people.service';
import { ModalCharacterComponent } from '../modal-character/modal-character.component';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-people-list',
  templateUrl: './people-list.component.html',
  styleUrl: './people-list.component.css'
})
export class PeopleListComponent implements OnInit{

  private modalService = inject(NgbModal)
  peopleList: Character[] = [];

  constructor(private service: PeopleService) {}

  getPeople(): void {

    this.service.getPeople().subscribe(res => {

      this.peopleList = res.results;
    })
  }

  ngOnInit(): void {
    this.getPeople();
  }

  getImage(character: Character):string {

    let id = parseInt(character.url.slice(29,30));

    return `https://starwars-visualguide.com/assets/img/characters/${id}.jpg`
  }

  open(character: Character) {

    const modalRef = this.modalService.open(ModalCharacterComponent);
    modalRef.componentInstance.character = character;
  }
}
