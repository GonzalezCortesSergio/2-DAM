import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Film } from '../../models/film.interface';

@Component({
  selector: 'app-film-detail',
  templateUrl: './film-detail.component.html',
  styleUrl: './film-detail.component.css'
})
export class FilmDetailComponent {

  @Input()
  film: Film | undefined
  @Output() filmChecked = new EventEmitter<number>();
  

  filmClicked(film: Film | undefined){

    console.log(film)
    this.filmChecked.emit(film?.episode_id);
  }
}
