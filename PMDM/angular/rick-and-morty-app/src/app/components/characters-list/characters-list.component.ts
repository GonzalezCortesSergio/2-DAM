import { Component, OnInit } from '@angular/core';
import { Character } from '../../interfaces/characters';
import { CharacterService } from '../../services/character.service';

@Component({
  selector: 'app-characters-list',
  templateUrl: './characters-list.component.html',
  styleUrl: './characters-list.component.css'
})
export class CharactersListComponent implements OnInit{


  charactersList: Character[] = [];

  constructor(private service: CharacterService) {}

  getCharacterList() {

    this.service.getCharacters().subscribe(res => {

      this.charactersList = res.results;
    })
  }

  ngOnInit(): void {
    
    this.getCharacterList();
    this.getEpisodeName();
  }

  getColorichi(_t2: Character) {
    
    if(_t2.status == "Alive") {

      return "alive";
    }
    if(_t2.status == "Dead"){
      return "dead";
    }
    return "unknown"
    
  }

  getEpisodeName() {

    this.charactersList.forEach((character, index) => {

      this.service.getFirstEpisode(character.episode[0]).subscribe(res => {

        character.firstEpisode = res.name;
      })
    })
  }
}
