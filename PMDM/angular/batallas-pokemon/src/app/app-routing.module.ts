import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PokemonBattleComponent } from './components/pokemon-battle/pokemon-battle.component';
import { PokemonComponent } from './components/pokemon/pokemon.component';

const routes: Routes = [
  {path: "battle", component: PokemonBattleComponent},
  {path: "", redirectTo: "/battle", pathMatch: "full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
