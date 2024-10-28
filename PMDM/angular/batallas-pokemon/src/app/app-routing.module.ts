import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PokemonBattleComponent } from './components/pokemon-battle/pokemon-battle.component';
import { PokemonListComponent } from './components/pokemon-list/pokemon-list.component';

const routes: Routes = [
  {path: "pokemon-list", component: PokemonListComponent},
  {path: "battle/:id/:id2", component: PokemonBattleComponent},
  {path: "", redirectTo: "/pokemon-list", pathMatch: "full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
