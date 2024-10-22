import { Character } from "./people"
import { Vehicle } from "./vehicle"

export interface Result {

  count: number
  next: string
  previous: any
  results: Vehicle[]
}
export interface ResultPeople {

  count: number;
  next: string;
  previous: string;
  results: Character[]
}
