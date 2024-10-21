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
  }

  getColorichi(_t2: Character) {
    
    if(_t2.status == "Alive") {

      return "alive";
    }
    return "dead";
    
  }

  getEpisodeName(episode: string) {

    this.service.getFirstEpisode(episode).subscribe(res => {

      return res.name;
    })
  }
}
