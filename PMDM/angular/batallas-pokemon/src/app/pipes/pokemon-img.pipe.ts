import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'pokemonImg'
})
export class PokemonImgPipe implements PipeTransform {

  transform(pokemonUrl: string, size: string): string {
    
    return "";
  }

}
