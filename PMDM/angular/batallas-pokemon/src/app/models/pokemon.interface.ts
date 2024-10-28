
export interface PokemonResponse {
    count: number
    next: string
    previous: any
    results: PokemonPreview[]
  }
export interface Atacar{

    pokemonId: number|undefined;
    danio: number;
}
  
  export interface PokemonPreview {
    name: string
    url: string
  }

  export interface Pokemon {

    id: number
    name: string
    sprites: Sprites
    stats: Stat[]
    types: Type[]
    weight: number
  }

  
  export interface Sprites {
    back_default: string
    back_female: any
    back_shiny: string
    back_shiny_female: any
    front_default: string
    front_female: any
    front_shiny: string
    front_shiny_female: any
  }
  
  export interface Stat {
    base_stat: number
    effort: number
    stat: Stat2
  }
  
  export interface Stat2 {
    name: string
    url: string
  }
  
  export interface Type {
    slot: number
    type: Type2
  }
  
  export interface Type2 {
    name: string
    url: string
  }
  