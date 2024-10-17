import { Component } from '@angular/core';


export interface CountryPhone {

  nombre: string;
  flag: string;
  prefix: number[];

}


const COUNTRY_PREFIXES: CountryPhone[] = [

  {nombre: "Spain", flag: "es", prefix: [34]},
  {
    nombre: "Dominican Republic",
    flag: "dr",
    prefix: [1]
  }
];


@Component({
  selector: 'app-phone-prefix-list',
  templateUrl: './phone-prefix-list.component.html',
  styleUrl: './phone-prefix-list.component.css'
})
export class PhonePrefixListComponent {

  countryPhones = COUNTRY_PREFIXES;


  getFlagImage(flag: string) {

    return `fi fi-${flag}` 
  }
}
